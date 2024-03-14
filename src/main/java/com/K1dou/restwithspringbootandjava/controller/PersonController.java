package com.K1dou.restwithspringbootandjava.controller;

import com.K1dou.restwithspringbootandjava.dto.PersonDTO;
import com.K1dou.restwithspringbootandjava.dto.PersonUpdateDTO;
import com.K1dou.restwithspringbootandjava.entity.Person;
import com.K1dou.restwithspringbootandjava.records.PersonRecord;
import com.K1dou.restwithspringbootandjava.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Person PostPerson(@RequestBody @Valid PersonDTO dto) {
        return personService.criar(dto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    private Person getPerson(@PathVariable Long id) {
        return personService.buscar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    private List<Person> findAll() {
        return personService.todosPerson();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Person delete(@PathVariable Long id) {
        Person person = personService.buscar(id);
        personService.delete(id);
        return person;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private Person update(@RequestBody PersonUpdateDTO dto) {
        return personService.update(dto);
    }


}
