package com.example.demo.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "reader")
public class ReaderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "user", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER,
        orphanRemoval = true)
    private List<BookEntity> books;
        
    public ReaderEntity(){
        this.books = new ArrayList<BookEntity>();
    }

    public ReaderEntity(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.books = new ArrayList<BookEntity>();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setBooks(List<BookEntity> books){
        this.books = books;
    }

    public void addBook(BookEntity book){
        this.books.add(book);
    }

    public Long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getEmail(){
        return this.email;
    }

    public List<BookEntity> getBooks(){
        return this.books;
    }

    @Override
    public String toString() {
        String myBooks = this.books.stream()
            .map(book -> book.getTitle())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", name='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", books=" + this.books +
                '}';
    }
}
