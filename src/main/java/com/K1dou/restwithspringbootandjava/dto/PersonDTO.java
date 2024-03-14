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




    public PersonDTO(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public PersonDTO() {
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
