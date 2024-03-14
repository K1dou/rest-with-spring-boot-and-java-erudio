package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.dto.PersonUpdateDTO;
import com.K1dou.restwithspringbootandjava.entity.Person;
import com.K1dou.restwithspringbootandjava.exception.ResourceNotFoundException;
import com.K1dou.restwithspringbootandjava.records.PersonRecord;
import com.K1dou.restwithspringbootandjava.repository.PersonRepository;
import com.K1dou.restwithspringbootandjava.dto.PersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Person criar(PersonDTO dto) {
        Person person = new Person();
        modelMapper.map(dto, person);
        personRepository.save(person);
        return person;
    }

    public Person buscar(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NÃO ENCONTRADO."));
    }

    public List<Person> todosPerson() {
        return personRepository.findAll();
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NÃO ENCONTRADO."));
        personRepository.deleteById(id);
    }

    public Person update(PersonUpdateDTO dto) {
        Long idPerson = dto.getId();
        Person person = personRepository.findById(idPerson).orElseThrow(() -> new ResourceNotFoundException("ID NÃO ENCONTRADO."));
        modelMapper.map(dto, person);
        personRepository.save(person);
        return person;
    }


}
