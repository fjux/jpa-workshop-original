package com.example.jpaworkshoporiginal.data;

import com.example.jpaworkshoporiginal.model.BookLoan;

import java.util.Collection;

public interface BookLoanDAO {
    BookLoan findById(int id);
    Collection<BookLoan> findAll();
    BookLoan create(BookLoan bookLoan);
    BookLoan update(BookLoan bookLoan);
    void delete(int id);
}
