package com.example.demo.customer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerForm {
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Only alphanumeric characters are allowed")
    private String name;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Only alphanumeric characters are allowed")
    private String lastName;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z]+.[a-zA-Z]+", message = "Only email formats are allowed")
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Email: " + this.email + ")";
    }
}