package com.K1dou.restwithspringbootandjava.dto.person.personv1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;

@JsonPropertyOrder({"id","fistName","lastName","address","gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    @Serial
    private static final long serialVersionUID = -7082268321854310714L;

    @JsonProperty("id")
    private Long key;
    @NotBlank(message = "Campo Fist Name obrigatório")
    private String fistName;
    @NotBlank(message = "Campo Last Name obrigatório")
    private String lastName;
    private String address;
    private String gender;


    public PersonDTO(Long key, String fistName, String lastName, String address, String gender) {
        this.key = key;
        this.fistName = fistName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public PersonDTO() {
    }


    public PersonDTO(Long key) {
        this.key = key;
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

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }
}
