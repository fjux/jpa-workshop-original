package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
@Transactional
public class AuthorDAORepository implements AuthorDAO{
    private final EntityManager entityManager;

    public AuthorDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class)
                .getResultList();
    }

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return author;
    }

    @Override
    public Author update(Author author) {
        if (author == null)throw new IllegalArgumentException("Author was null");
        return entityManager.merge(author);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));

    }
}
