package com.example.task.dao;

import com.example.task.model.Persen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/java";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Persen> select() throws SQLException {
        List<Persen> people = new ArrayList<>();

        Statement statement = connection.createStatement();
        String SQL = "SELECT * FROM Person";
        ResultSet resultSet=statement.executeQuery(SQL);

        while (resultSet.next()){
            Persen persen = new Persen(resultSet.getInt("id"),resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getInt("age"),resultSet.getDouble("mark"),resultSet.getBoolean("education"),resultSet.getString("category").charAt(0));
            people.add(persen);
        }
        return  people;
    }
    public static Persen selectOne(int id) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Persen persen = new Persen(resultSet.getInt("id"),resultSet.getString("firstname"),resultSet.getString("lastname"),resultSet.getInt("age"),resultSet.getDouble("mark"),resultSet.getBoolean("education"),resultSet.getString("category").charAt(0));

        return  persen;
    }

    public static void save(Persen persen) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person(firstname, lastname, age, mark, education,category) VALUES(?,?,?,?,?,?)");
        preparedStatement.setString(1,persen.getFirstName());
        preparedStatement.setString(2,persen.getLastName());
        preparedStatement.setInt(3,persen.getAge());
        preparedStatement.setDouble(4,persen.getMark());
        preparedStatement.setBoolean(5,persen.isEducation());
        preparedStatement.setString(6,String.valueOf(persen.getCategory()));
        preparedStatement.executeUpdate();
    }
    public static void update(int id, Persen updatePerson) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Person SET firstname=?,lastname=?,age=?,mark=?,education=?,category=? WHERE id=?");

        preparedStatement.setString(1,updatePerson.getFirstName());
        preparedStatement.setString(2,updatePerson.getLastName());
        preparedStatement.setInt(3,updatePerson.getAge());
        preparedStatement.setDouble(4,updatePerson.getMark());
        preparedStatement.setBoolean(5,updatePerson.isEducation());
        preparedStatement.setString(6,String.valueOf(updatePerson.getCategory()));
        preparedStatement.setInt(7,id);
        preparedStatement.executeUpdate();
    }
    public static void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
}
