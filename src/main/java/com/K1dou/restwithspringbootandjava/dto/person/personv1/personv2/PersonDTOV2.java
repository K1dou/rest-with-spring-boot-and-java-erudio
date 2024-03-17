package com.K1dou.restwithspringbootandjava.dto.person.personv1.personv2;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PersonDTOV2 {

    private Long id;
    @NotBlank(message = "Campo Fist Name obrigatório")
    private String fistName;
    @NotBlank(message = "Campo Last Name obrigatório")
    private String lastName;
    private String address;
    private String gender;
    private Date birthDay;


    public PersonDTOV2(Long id, String fistName, String lastName, String address, String gender, Date birthDay) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public PersonDTOV2() {
    }


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public PersonDTOV2(Long id) {
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
