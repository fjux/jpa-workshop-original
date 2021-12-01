package com.example.jpaworkshoporiginal.model;

import java.time.LocalDate;

public class Details {
    private int detailsId;
    private String email;
    private String name;
    private LocalDate birthDate;

    public Details() {
    }

    public Details(int detailsId, String email, String name, LocalDate birthDate) {
        this.detailsId = detailsId;
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}