package com.dereveskyi.markiyan.sushi_shop.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Please, enter name!")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "Please, enter surname!")
    private String surname;

    @Column(name = "email")
    @Email(message = "Please, enter a valid email!")
    @NotBlank(message = "Please, enter email!")
    private String email;

    @OneToOne(mappedBy = "user")
    private Order order;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
