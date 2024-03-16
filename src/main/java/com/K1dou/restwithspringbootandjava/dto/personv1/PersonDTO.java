package com.K1dou.restwithspringbootandjava.dto.personv1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;

@JsonPropertyOrder({"id","fistName","lastName","address","gender"})
public class PersonDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7082268321854310714L;

    private Long id;
    @NotBlank(message = "Campo Fist Name obrigatório")
    private String fistName;
    @NotBlank(message = "Campo Last Name obrigatório")
    private String lastName;
    private String address;
    private String gender;


    public PersonDTO(Long id, String fistName, String lastName, String address, String gender) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonDTO() {
    }


    public PersonDTO(Long id) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
