package com.K1dou.restwithspringbootandjava.dto.book.bookv1;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class BookDTO extends RepresentationModel<BookDTO> implements Serializable {

    @Serial
    private static final long serialVersionUID = 6303307383040882626L;

    private Long id;
    @NotBlank(message = "Campo author obrigatório.")
    private String author;
    @NotBlank(message = "Campo launch date obrigatório.")
    private Date launchDate;
    @NotNull(message = "Campo price não pode ser nulo.")
    private Double price;
    @NotBlank(message = "Campo title obrigatório.")
    private String title;

    public BookDTO(Long id, String author, Date launchDate, Double price, String title) {
        this.id = id;
        this.author = author;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
    }

    public BookDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
