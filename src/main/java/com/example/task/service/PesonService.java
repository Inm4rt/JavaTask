package com.example.task.service;

import com.example.task.dto.PersonDto;
import com.example.task.model.Person;
import com.example.task.repository.PersonRepository;
import com.example.task.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PesonService {
    @Autowired
    private PersonRepository personRepository;

    private final MappingUtils mappingUtils = new MappingUtils();

    public void addPerson(PersonDto person) {
        personRepository.save(mappingUtils.mapToPerson(person));
    }

    public PersonDto getOnePerson(long id) {
        return mappingUtils.mapToPersonDTO(personRepository.findById(id).orElse(new Person()));
    }

    public Iterable<PersonDto> getAllPerson() {
        Iterable<PersonDto> a = personRepository.findAll().stream().map(mappingUtils::mapToPersonDTO).collect(Collectors.toList());
        return a;
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(PersonDto person) {
        personRepository.save(mappingUtils.mapToPerson(person));
    }
}
