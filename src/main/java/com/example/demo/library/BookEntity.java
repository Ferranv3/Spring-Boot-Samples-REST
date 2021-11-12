package com.example.demo.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long isbn;
    private String title;
    private String author;
    private String description;
    private boolean available;

    @ManyToOne()
    //@JsonIgnore
    @JsonBackReference
    @JoinColumn(name = "reader_id")
    private ReaderEntity user;

    public BookEntity(){}

    public BookEntity(Long isbn, String title, String author, String description, boolean available){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = available;
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

    public void setAvailable(boolean available){
        this.available = available;
    }

    public void setUser(ReaderEntity user){
        this.user = user;
    }

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

    public boolean isAvailable(){
        return user == null;
    }

    public ReaderEntity getUser(){
        return this.user;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + this.id +
                ", isbn='" + this.isbn + '\'' +
                ", title='" + this.title + '\'' +
                ", author='" + this.author + '\'' +
                ", description='" + this.description  + '\'' +
                ", description='" + this.isAvailable()  + '\'' +
                '}';

    }
}
