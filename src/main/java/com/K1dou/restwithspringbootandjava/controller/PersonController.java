package com.K1dou.restwithspringbootandjava.controller;

import com.K1dou.restwithspringbootandjava.dto.personv1.PersonDTO;
import com.K1dou.restwithspringbootandjava.dto.personv1.PersonUpdateDTO;
import com.K1dou.restwithspringbootandjava.dto.personv2.PersonDTOV2;
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
    private PersonDTO PostPerson(@RequestBody @Valid PersonDTO dto) {
        return personService.criar(dto);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    private PersonDTO getPerson(@PathVariable Long id) {
        return personService.buscar(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    private List<PersonDTO> findAll() {
        return personService.todosPerson();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private PersonDTO delete(@PathVariable Long id) {
        PersonDTO person = personService.buscar(id);
        personService.delete(id);
        return person;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    private PersonDTO update(@RequestBody PersonUpdateDTO dto) {
        return personService.update(dto);
    }


    @PostMapping("/api/person/v1")
    @ResponseStatus(HttpStatus.CREATED)
    private PersonDTOV2 PostPerson(@RequestBody @Valid PersonDTOV2 dto) {
        return personService.criarV2(dto);

    }







}
