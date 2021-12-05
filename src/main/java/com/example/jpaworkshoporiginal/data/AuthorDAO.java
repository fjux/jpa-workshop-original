package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.Author;

import java.util.Collection;

public interface AuthorDAO {
    Author findById(int id);
    Collection<Author> findAll();
    Author create(Author author);
    Author update(Author author);
    void delete(int id);
}
