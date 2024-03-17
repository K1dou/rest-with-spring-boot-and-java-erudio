package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.controller.BookController;
import com.K1dou.restwithspringbootandjava.dto.book.bookv1.BookDTO;
import com.K1dou.restwithspringbootandjava.entity.Book;
import com.K1dou.restwithspringbootandjava.exception.ResourceNotFoundException;
import com.K1dou.restwithspringbootandjava.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;


    public BookDTO criar(BookDTO dto) {
        Book book = new Book();

        modelMapper.map(dto, book);
        bookRepository.save(book);
        dto.setId(book.getId());
        return dto;
    }

    public List<BookDTO> listar() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> dtos = books.stream().map(book -> new BookDTO(book.getId(),book.getAuthor(),book.getLaunchDate(),book.getPrice(),book.getTitle())).collect(Collectors.toList());
       dtos.stream().forEach(bo -> bo.add(linkTo(methodOn(BookController.class).getBooks(bo.getId())).withSelfRel()));
        return dtos;
    }

    public BookDTO findId(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id não encontrado."));
        BookDTO bookDTO = new BookDTO();
        modelMapper.map(book,bookDTO);
        bookDTO.add(linkTo(methodOn(BookController.class).getBooks(id)).withSelfRel());
        return bookDTO;
    }

    public BookDTO update(BookDTO dto){
        Long idBook = dto.getId();
        Book book = bookRepository.findById(idBook).orElseThrow(()->new ResourceNotFoundException("Id não encontrado."));
        modelMapper.map(dto,book);
        BookDTO bookDTO = new BookDTO();
        bookRepository.save(book);
        modelMapper.map(book,bookDTO);
        bookDTO.add(linkTo(methodOn(BookController.class).findById(idBook)).withSelfRel());
        return bookDTO;
    }

    public void delete(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id não encontrado."));
        bookRepository.deleteById(id);
    }


}
