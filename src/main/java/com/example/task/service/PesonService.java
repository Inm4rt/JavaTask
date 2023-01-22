package com.example.task.service;

import com.example.task.dto.PersonDto;
import com.example.task.exceptions.BusinessException;
import com.example.task.model.Person;
import com.example.task.repository.PersonRepository;
import com.example.task.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PesonService {
    @Autowired
    private PersonRepository personRepository;

    private final MappingUtils mappingUtils = new MappingUtils();

    public void addPerson(PersonDto person) {
        personRepository.save(mappingUtils.mapToPerson(person));
    }

    public PersonDto getOnePerson(long id) throws BusinessException {
        Optional<Person> person = personRepository.findOnePerson(id);
        if (person.isEmpty()){
            throw new BusinessException("Пользователь не найден");
        }
        return mappingUtils.mapToPersonDTO(personRepository.findOnePerson(id).orElse(new Person()));
    }

    public Iterable<PersonDto> getAllPerson() {
        return personRepository.findAllPerson().stream().map(mappingUtils::mapToPersonDTO).collect(Collectors.toList());
    }

    public void deletePerson(long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(PersonDto person) {
        personRepository.save(mappingUtils.mapToPerson(person));
    }
}
