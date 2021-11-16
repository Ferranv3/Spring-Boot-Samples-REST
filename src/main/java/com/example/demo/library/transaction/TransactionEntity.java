package com.example.demo.library.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.library.book.BookEntity;
import com.example.demo.library.reader.ReaderEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("transaction_date")
    private String transactionDate;

    @JsonProperty("status_date")
    private String statusDate;

    @JsonProperty("due_date")
    private String dueDate;

    @JsonProperty("status")
    private String status;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "reader_id")
    private ReaderEntity reader;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    private BookEntity book;

    public TransactionEntity(){}

    public TransactionEntity(String transactionDate, String statusDate, String dueDate, String status){
        this.transactionDate = transactionDate;
        this.statusDate = statusDate;
        this.status = status;
    }
    
    public TransactionEntity(String transactionDate, String statusDate, String dueDate, String status, 
                            BookEntity book, ReaderEntity reader){
        this.transactionDate = transactionDate;
        this.statusDate = statusDate;
        this.status = status;
        this.book = book;
        this.reader = reader;
    }

    public void setTransactionDate(String transactionDate){
        this.transactionDate = transactionDate;
    }

    public void setStatusDate(String statusDate){
        this.statusDate = statusDate;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setBook(BookEntity book){
        this.book = book;
    }

    public void setReader(ReaderEntity reader){
        this.reader = reader;
    }

    public String getTransactionDate(){
        return this.transactionDate;
    }

    public String getStatusDate(){
        return this.statusDate;
    }

    public String getStatus(){
        return this.status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public BookEntity getBook(){
        return this.book;
    }

    public ReaderEntity getReader(){
        return this.reader;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + this.id +
                ", transactionDate='" + this.transactionDate + '\'' +
                ", dueDate='" + this.dueDate + '\'' +
                ", status='" + this.status + '\'' +
                ", book='" + this.book + '\'' +
                ", reader='" + this.reader  + '\'' +
                '}';
    }
}
