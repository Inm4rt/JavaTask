package com.example.task.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private ObjectMapper objectMapper;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public Iterable<Persen> showAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/one")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity showOnePerson(@RequestParam(name = "id") long id, Persen persen) throws JsonProcessingException {
        Optional<Persen> serch = personService.getOnePerson(id);
        if (serch.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(serch);
        }
        return  ResponseEntity.status(HttpStatus.OK).body(serch);
    }
    @PutMapping("/update")
    public ResponseEntity updatePerson(@Valid @RequestBody Persen person){
        personService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }
    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") long id){
        personService.deletePerson(id);
    }

    @PostMapping("/")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity AddPerson(@Valid @RequestBody Persen person){

        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Valid");
    }
}
