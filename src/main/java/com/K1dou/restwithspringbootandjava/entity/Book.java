package com.K1dou.restwithspringbootandjava.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book_tb")
public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = -452886346353040278L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    @Column(name = "launch_date")
    @Temporal(TemporalType.DATE)
    private Date launchDate;
    private Double price;
    private String title;


    public Book() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    //id bigint NOT NULL AUTO_INCREMENT,
//    author varchar(255) DEFAULT NULL,
//    launch_date DATE DEFAULT NULL,
//    price decimal(65.2) DEFAULT NULL,
//    title varchar(


}
