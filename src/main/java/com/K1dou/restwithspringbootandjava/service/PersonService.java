package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.controller.PersonController;
import com.K1dou.restwithspringbootandjava.dto.person.personV1.PersonUpdateDTO;
import com.K1dou.restwithspringbootandjava.dto.person.personV1.personV2.PersonDTOV2;
import com.K1dou.restwithspringbootandjava.entity.Person;
import com.K1dou.restwithspringbootandjava.exception.ResourceNotFoundException;
import com.K1dou.restwithspringbootandjava.repository.PersonRepository;
import com.K1dou.restwithspringbootandjava.dto.person.personV1.PersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PersonDTO criar(PersonDTO dto) {

        modelMapper.createTypeMap(
                        Person.class, PersonDTO.class)
                .addMapping(Person::getId, PersonDTO::setKey);

        modelMapper.createTypeMap(
                        PersonDTO.class, Person.class)
                .addMapping(PersonDTO::getKey, Person::setId);


        Person person = new Person();
        modelMapper.map(dto, person);
        personRepository.save(person);
        PersonDTO personDTO = new PersonDTO();
        modelMapper.map(person, personDTO);

        personDTO.add(linkTo(methodOn(PersonController.class).getPerson(person.getId())).withSelfRel());

        return personDTO;
    }

    public PersonDTOV2 criarV2(PersonDTOV2 dto) {
        Person person = new Person();
        modelMapper.map(dto, person);
        personRepository.save(person);
        PersonDTOV2 personDTOV2 = new PersonDTOV2();
        modelMapper.map(person, personDTOV2);
        return personDTOV2;
    }

    public PersonDTO buscar(Long id) {

        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NÃO ENCONTRADO."));
        PersonDTO personDTO = new PersonDTO();
        modelMapper.map(person, personDTO);
        personDTO.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());
        return personDTO;
    }

    public List<PersonDTO> todosPerson() {
        List<Person> p = personRepository.findAll();
        List<PersonDTO> pDTO = p.stream().map(person -> new PersonDTO(person.getId(), person.getFistName(), person.getLastName(), person.getAddress(), person.getGender()))
                .collect(Collectors.toList());
        pDTO.stream().forEach(pe -> pe.add(linkTo(methodOn(PersonController.class).getPerson(pe.getKey())).withSelfRel()));
        return pDTO;
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NÃO ENCONTRADO."));
        personRepository.deleteById(id);
    }

    public PersonDTO update(PersonUpdateDTO dto) {


        Long idPerson = dto.getId();
        Person person = personRepository.findById(idPerson).orElseThrow(() -> new ResourceNotFoundException("ID NÃO ENCONTRADO."));
        modelMapper.map(dto, person);
        personRepository.save(person);
        PersonDTO personDTO = new PersonDTO();
        modelMapper.map(person, personDTO);
        personDTO.add(linkTo(methodOn(PersonController.class).getPerson(person.getId())).withSelfRel());
        return personDTO;
    }


}