package com.example.demo.library.library;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.library.book.BookEntity;
import com.example.demo.library.reader.ReaderEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "library")
public class LibraryEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;

    /*@JsonManagedReference
    @OneToMany(
        mappedBy = "library", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER,
        orphanRemoval = true)
    private List<ReaderEntity> readers;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "library", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER,
        orphanRemoval = true)
    private List<BookEntity> books;*/

    public LibraryEntity(){

    }

    public LibraryEntity(String name, String city, List<ReaderEntity> readers, List<BookEntity> books){
        this.name = name;
        this.city = city;
        /*if(readers.isEmpty()){
            this.readers = new ArrayList();
        }else{
            this.readers = this.readers;
        }
        if(books.isEmpty()){
            this.books = new ArrayList();
        }else{
            this.books = this.books;
        }*/
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCity(String city){
        this.city = city;
    }

    /*public void setReaders(List<ReaderEntity> readers){
        this.readers = readers;
    }

    public void setBooks(List<BookEntity> books){
        this.books = books;
    }*/

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    /*public List<ReaderEntity> getReaders(){
        return this.readers;
    }

    public List<BookEntity> getBooks(){
        return this.books;
    }

    public void addBook(BookEntity book){
        this.books.add(book);
    }

    public void addReader(ReaderEntity reader){
        this.readers.add(reader);
    }*/

    @Override
    public String toString() {
        /*String myReaders = this.readers.stream()
            .map(reader -> reader.getFirstName())
            .reduce("", (acc, name) -> acc + name + ", ");
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                ", books=" + myBooks + '\'' +
                ", redaers=" + myReaders +
                '}';*/
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", city='" + this.city;
    }
}
