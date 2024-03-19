package com.K1dou.restwithspringbootandjava.dto.person.personV1;

import jakarta.validation.constraints.NotBlank;

public class PersonUpdateDTO {



    private Long id;
    @NotBlank(message = "Campo Last Name obrigatório")
    private String lastName;
    private String address;

    public PersonUpdateDTO(String lastName, String address, Long id) {

        this.lastName = lastName;
        this.address = address;
        this.id=id;

    }

    public PersonUpdateDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
