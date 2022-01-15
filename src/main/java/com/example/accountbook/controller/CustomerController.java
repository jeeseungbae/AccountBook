package com.example.accountbook.controller;

import com.example.accountbook.domain.Customer;
import com.example.accountbook.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/project")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@Valid @RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.signUp(customer));
    }
}
