package com.example.demo.library.book;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.library.transaction.TransactionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long isbn;
    private String title;
    private String author;
    
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @JsonIgnore
    @OneToMany(
        mappedBy = "book", 
        cascade = CascadeType.ALL, 
        fetch = javax.persistence.FetchType.LAZY,
        orphanRemoval = true)
    private List<TransactionEntity> transactions;

    public BookEntity(){
        this.transactions = new java.util.ArrayList<TransactionEntity>();
    }

    public BookEntity(Long isbn, String title, String author, String description){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public void setIsbn(Long isbn){
        this.isbn = isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTransactions(List<TransactionEntity> transactions){
        this.transactions = transactions;
    }

    /*public void setLibrary(LibraryEntity library){
        this.library = library;
    }*/

    public Long getId(){
        return this.id;
    }

    public Long getIsbn(){
        return this.isbn;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getDescription(){
        return this.description;
    }

    public List<TransactionEntity> getTransactions(){
        return this.transactions;
    }

    /*public LibraryEntity getLibrary(){
        return this.library;
    }*/

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + this.id +
                ", isbn='" + this.isbn + '\'' +
                ", title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", description='" + this.description  + '\'' +
                '}';
    }
}
