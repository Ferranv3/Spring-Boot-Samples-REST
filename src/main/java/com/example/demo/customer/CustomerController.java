package com.example.demo.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers")
    public String greeting(CustomerForm customerForm, Model model) {
        model.addAttribute("customers", repository.findAll());
        return "customers";
    }

    @PostMapping("/customers")
    public String checkCustomernInfo(@Validated CustomerForm customerForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customers", repository.findAll());
            return "customers";
        }
        List<Customer> customers = repository.findByEmail(customerForm.getEmail());
        if(customers.size() > 0){
            model.addAttribute("mailExists", "Email already exist");
            model.addAttribute("customers", repository.findAll());
            return "customers";
        }
        repository.save(new Customer(customerForm.getName(), customerForm.getLastName(), customerForm.getEmail()));
        return "redirect:/customers";    
    } 
}
