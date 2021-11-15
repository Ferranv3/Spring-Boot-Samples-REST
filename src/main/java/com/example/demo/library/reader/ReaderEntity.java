package com.example.demo.library.reader;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.library.transaction.TransactionEntity;
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
        mappedBy = "reader", 
        cascade = CascadeType.ALL, 
        fetch = javax.persistence.FetchType.LAZY,
        orphanRemoval = true)
    private List<TransactionEntity> transactions;

    /*@ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "library_id")
    private LibraryEntity library;*/
        
    public ReaderEntity(){
        this.transactions = new ArrayList<TransactionEntity>();
    }

    public ReaderEntity(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.transactions = new ArrayList<TransactionEntity>();
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

    /*public void setLibrary(LibraryEntity library){
        this.library = library;
    }*/

    public void setTransactions(List<TransactionEntity> transactions){
        this.transactions = transactions;
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

    /*public LibraryEntity getLibrary(){
        return this.library;
    }*/

    public void addBook(TransactionEntity book) {
        this.transactions.add(book);
    }

    @Override
    public String toString() {
        String myTransactions = this.transactions.stream()
            .map(transaction -> transaction.toString())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", name='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", transactions=" + myTransactions +
                '}';
    }
}
