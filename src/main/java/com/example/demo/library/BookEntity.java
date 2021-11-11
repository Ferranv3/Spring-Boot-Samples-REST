package com.example.demo.library;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long isbn;
    private String title;
    private String author;
    private String description;
    //private ReaderEntity lectorReading;

    /*@ManyToOne()
    @JoinColumn(name = "lector_id")*/

    public BookEntity(){}

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

    /*public void setLectorReading(ReaderEntity lectorReading){
        this.lectorReading = lectorReading;
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

    /*public ReaderEntity getReaderReading(){
        return this.lectorReading;
    }*/
}
