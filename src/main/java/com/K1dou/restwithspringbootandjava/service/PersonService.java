package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.entity.Person;
import com.K1dou.restwithspringbootandjava.exception.ResourceNotFoundException;
import com.K1dou.restwithspringbootandjava.repository.PersonRepository;
import com.K1dou.restwithspringbootandjava.dto.PersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;



    public PersonDTO criar (PersonDTO dto){
        Person person = new Person();
        modelMapper.map(dto,person);
        personRepository.save(person);
        return dto;
    }

    public Person buscar (Long id){
        Person person = personRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID NÃO ENCONTRADO."));
        return person;
    }







}
