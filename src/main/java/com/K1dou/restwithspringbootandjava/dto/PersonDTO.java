package com.K1dou.restwithspringbootandjava.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class PersonDTO {

    @NotBlank(message = "Campo Fist Name obrigatório")
    private String fistName;
    @NotBlank(message = "Campo Last Name obrigatório")
    private String lastName;
    private String address;
    private String gender;


    public PersonDTO(String fistName, String lastName, String address, String gender) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonDTO() {
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
}
