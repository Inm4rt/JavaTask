package com.example.task.service;

import com.example.task.model.Person;
import com.example.task.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PesonService {
    @Autowired
    private PersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public Optional<Person> getOnePerson(long id) {
        return personRepository.findById(id);
    }

    public Iterable<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }
}
