package com.example.task.utils;

import com.example.task.dto.PersonDto;
import com.example.task.model.Person;

public class MappingUtils {
    public PersonDto mapToPersonDTO(Person entity){
        PersonDto personDto = new PersonDto();
        personDto.setId(entity.getId());
        personDto.setFirstName(entity.getFirstName());
        personDto.setLastName(entity.getLastName());
        personDto.setAge(entity.getAge());
        personDto.setCategory(entity.getCategory());
        personDto.setMark(entity.getMark());
        personDto.setEducation(entity.isEducation());
        return personDto;
    }
    public Person mapToPerson(PersonDto dto){
        Person person = new Person();
        person.setId(dto.getId());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setAge(dto.getAge());
        person.setCategory(dto.getCategory());
        person.setMark(dto.getMark());
        person.setEducation(dto.isEducation());
        return person;
    }
}
