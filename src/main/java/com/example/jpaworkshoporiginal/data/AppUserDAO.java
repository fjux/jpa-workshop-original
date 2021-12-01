package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.AppUser;

import java.util.Collection;

public interface AppUserDAO {
    AppUser findById(int id);
    Collection<AppUser> findAll();
    AppUser create(AppUser appUser);
    AppUser update(AppUser appUser);
    void delete(int id);
}
