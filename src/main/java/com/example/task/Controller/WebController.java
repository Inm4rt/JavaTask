package com.example.task.Controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.task.model.Persen;
import com.example.task.service.PesonService;


import java.sql.SQLException;
import java.util.Optional;

@RestController
public class WebController {
    @Autowired
    private PesonService personService = new PesonService();
    @GetMapping("/")
    public Iterable<Persen> showAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/one")
    public Optional<Persen> showOnePerson(@RequestParam(name = "id") long id, Persen persen){
        return personService.getOnePerson(id);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@Valid @RequestBody Persen person){

        personService.updatePerson(person);
        return ResponseEntity.ok("valid");
    }
    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") long id){
        personService.deletePerson(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> AddPerson(@Valid @RequestBody Persen person){

        personService.addPerson(person);
        return ResponseEntity.ok("valid");
    }
}
