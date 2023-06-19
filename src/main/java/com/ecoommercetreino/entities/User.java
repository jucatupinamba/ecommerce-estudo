package com.ecoommercetreino.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String prone;
    private String password;

    public User () {}

    public User(Long id, String name, String email, String prone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.prone = prone;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProne() {
        return prone;
    }

    public void setProne(String prone) {
        this.prone = prone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
