package com.example.task.repository;

import com.example.task.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("SELECT u FROM Person u")
    Collection<Person> findAllPerson();
    @Query("SELECT u FROM Person u WHERE u.id = ?1")
    Optional<Person> findOnePerson(long id);
}
