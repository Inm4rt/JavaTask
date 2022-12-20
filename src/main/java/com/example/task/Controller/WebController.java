package com.example.task.Controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.task.model.Persen;
import com.example.task.dao.PersonDAO;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.sql.SQLException;
import java.util.List;

@RestController
public class WebController implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public List<Persen> showAllPerson() throws SQLException {

        return PersonDAO.select();
    }

    @GetMapping("/one")
    public Persen showOnePerson(@RequestParam(name = "id") int id,Persen persen) throws SQLException {
        return PersonDAO.selectOne(id);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestParam(name = "id") int id, @Valid @RequestBody Persen person) throws SQLException {

        PersonDAO.update(id,person);
        return ResponseEntity.ok("valid");
    }
    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") int id) throws SQLException {
        PersonDAO.delete(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> AddPerson(@Valid @RequestBody Persen person) throws SQLException {

        PersonDAO.save(person);
        return ResponseEntity.ok("valid");
    }
}
