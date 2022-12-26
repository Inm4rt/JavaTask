package com.example.task.service;

import com.example.task.model.Persen;
import com.example.task.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class PesonService {
    @Autowired
    private PersonRepository personRepository;
//@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age,@RequestParam double mark,@RequestParam boolean education,@RequestParam char category
    public void addPerson(Persen person){
        //Persen persen = new Persen(person.getFirstName(),person.getLastName(),person.getAge(),person.getMark(),person.isEducation(),person.getCategory());
        personRepository.save(person);
    }

    public Optional<Persen> getOnePerson(long id){
        return personRepository.findById(id);
    }

    public Iterable<Persen> getAllPerson(){
        return personRepository.findAll();
    }

    public void deletePerson(long id){
        personRepository.deleteById(id);
    }
    public void updatePerson(Persen persen){
        personRepository.save(persen);
    }
}
