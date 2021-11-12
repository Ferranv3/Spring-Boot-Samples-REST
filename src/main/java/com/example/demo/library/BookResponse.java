package com.example.demo.library;

public class BookResponse {
    private Long id;
    private Long isbn;
    private String title;
    private String author;
    private String description;
    private boolean available;

    public BookResponse(){}

    public BookResponse(Long id, Long isbn, String title, String author, String description, boolean available){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.description = description;
        this.available = available;
    }

    public void setId(Long id){
        this.id = id;
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
        return this.available;
    }
}
