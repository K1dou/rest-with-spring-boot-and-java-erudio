package com.K1dou.restwithspringbootandjava.controller;

import com.K1dou.restwithspringbootandjava.dto.book.bookv1.BookDTO;
import com.K1dou.restwithspringbootandjava.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO postBook(@RequestBody @Valid BookDTO dto) {
        return bookService.criar(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<BookDTO> getBooks(Long id) {
        return bookService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BookDTO findById(@PathVariable Long id) {
        return bookService.findId(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookDTO update(@RequestBody BookDTO dto) {
        return bookService.update(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }


}
