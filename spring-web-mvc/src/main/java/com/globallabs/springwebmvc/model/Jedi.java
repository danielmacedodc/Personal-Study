package com.globallabs.springwebmvc.model;


import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Table(name = "jedi")
public class Jedi {

    @Id
    @Column(name = "id_jedi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 10, message = "Nome deve conter entre 3 e 10 caracteres.")
    @NotBlank(message = "Name cannot be blank.")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "last_name")
    private String lastName;

    public Jedi(final String name, final String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Jedi(Jedi jedi) {
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
