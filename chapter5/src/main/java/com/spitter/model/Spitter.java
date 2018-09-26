package com.spitter.model;

import java.util.List;

public class Spitter {

    private Long id;
    private String username;
    private String password;
    private String fullName;
    private List<Spittle> spittles;
    private String email;
    private boolean updateByEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isUpdateByEmail() {
        return updateByEmail;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spitter spitter = (Spitter) o;

        return id.equals(spitter.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
