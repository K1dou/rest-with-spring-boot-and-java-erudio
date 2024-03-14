package com.K1dou.restwithspringbootandjava.controller;

import com.K1dou.restwithspringbootandjava.dto.PersonDTO;
import com.K1dou.restwithspringbootandjava.entity.Person;
import com.K1dou.restwithspringbootandjava.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private PersonDTO PostPerson(@RequestBody @Valid PersonDTO dto){
        personService.criar(dto);
        return dto;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    private Person getPerson(@PathVariable Long id){
        return personService.buscar(id);

    }






}
