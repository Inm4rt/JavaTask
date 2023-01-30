package com.example.task.Controller;

import com.example.task.TaskApplication;
import com.example.task.dto.PersonDto;
import com.example.task.exceptions.BusinessException;
import com.example.task.exceptions.AddException;
import com.example.task.service.PesonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WebController {
    private static final Logger log = LoggerFactory.getLogger(TaskApplication.class);
    @Autowired
    private PesonService personService = new PesonService();

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public Iterable<PersonDto> showAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/one")
    public ResponseEntity showOnePerson(@RequestParam(name = "id") long id) throws BusinessException {
        PersonDto searchPerson = personService.getOnePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body(searchPerson);
    }

    @PutMapping("/update")
    public ResponseEntity updatePerson(@Valid @RequestBody PersonDto person) {
        personService.updatePerson(person);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") long id) {
        personService.deletePerson(id);
    }

    @PostMapping("/")
    public ResponseEntity AddPerson(@Valid @RequestBody PersonDto person){
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Valid");
    }

}
