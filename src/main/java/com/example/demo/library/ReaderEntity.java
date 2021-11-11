package com.example.demo.library;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "reader")
public class ReaderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    //private List<BookEntity> bookLended;

    /*@OneToMany(
        mappedBy = "reader", 
        cascade = CascadeType.ALL)*/
        
    public ReaderEntity(){}

    public ReaderEntity(String firstName, String lastName){//}, List<BookEntity> bookLended){
        this.firstName = firstName;
        this.lastName = lastName;
        //this.bookLended = bookLended;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /*public void setBookLended(List<BookEntity> bookLended){
        this.bookLended = bookLended;
    }*/

    public Long getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    /*public List<BookEntity> getBookLended(){
        return this.bookLended;
    }*/
}
