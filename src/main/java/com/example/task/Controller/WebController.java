package com.example.task.Controller;

import com.example.task.model.Person;
import com.example.task.service.PesonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Person> showAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/one")
    public ResponseEntity showOnePerson(@RequestParam(name = "id") long id, Person person){
        Optional<Person> searchPerson = personService.getOnePerson(id);
        if (searchPerson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(searchPerson);
        }
        return ResponseEntity.status(HttpStatus.OK).body(searchPerson);
    }

    @PutMapping("/update")
    public ResponseEntity updatePerson(@Valid @RequestBody Person person) {
        personService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") long id) {
        personService.deletePerson(id);
    }

    @PostMapping("/")
    public ResponseEntity AddPerson(@Valid @RequestBody Person person) {

        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Valid");
    }
}
