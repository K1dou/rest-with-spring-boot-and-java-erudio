package com.K1dou.restwithspringbootandjava.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "person_tb")
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = -8913360430837064421L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fist_name")
    private String fistName;
    @Column(name = "last_name")
    private String lastName;
    private String address;
    private String gender;







    public Person() {
    }

    public Person(Long id, String fistName, String lastName, String address, String gender) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
