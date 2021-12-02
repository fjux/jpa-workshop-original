package com.example.jpaworkshoporiginal.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int appUserId;
    @Column(length = 100, unique = true)
    private String username;
    private String password;
    private LocalDate regDate;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_details_id")
    private Details userDetails;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "borrower")
    private List<BookLoan> loans;

    public AppUser() {
    }

    public AppUser(int appUserId, String username, String password, LocalDate regDate, Details userDetails, List<BookLoan> loans) {
        this.appUserId = appUserId;
        this.username = username;
        this.password = password;
        this.regDate = regDate;
        this.userDetails = userDetails;
        this.loans = loans;
    }

    public int getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(int appUserId) {
        this.appUserId = appUserId;
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

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public Details getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Details userDetails) {
        this.userDetails = userDetails;
    }

    public void borrowBook(BookLoan bookLoan){
        loans.add(bookLoan);
        bookLoan.setBorrower(this);
    }

    public void returnBook(BookLoan bookLoan){
        bookLoan.setBorrower(null);
        loans.remove(bookLoan);
    }


}
