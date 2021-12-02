package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
@Repository
@Transactional
public class BookDAORepository implements BookDAO{

    private final EntityManager entityManager;

    public BookDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public Collection<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class)
                .getResultList();
    }

    @Override
    public Book create(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
        public Book update(Book book) {
        if (book == null) throw new IllegalArgumentException("Book was null");
        return entityManager.merge(book);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));

    }
}
