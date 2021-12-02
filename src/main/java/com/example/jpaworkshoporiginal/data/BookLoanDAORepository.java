package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.BookLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;
@Repository
@Transactional
public class BookLoanDAORepository implements BookLoanDAO{

    private final EntityManager entityManager;

    @Autowired
    public BookLoanDAORepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public BookLoan findById(int id) {
        return entityManager.find(BookLoan.class, id);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("SELECT b FROM BookLoan b", BookLoan.class)
                .getResultList();
    }

    @Override
    public BookLoan create(BookLoan bookLoan) {
        if (bookLoan == null) throw new IllegalArgumentException("BookLoan was null");
        entityManager.persist(bookLoan);
        return bookLoan;
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(findById(id));
    }
}
