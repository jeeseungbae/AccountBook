package com.example.accountbook.controller;

import com.example.accountbook.config.JwtTokenProvider;
import com.example.accountbook.domain.Customer;
import com.example.accountbook.domain.dto.CustomerDto;
import com.example.accountbook.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final JwtTokenProvider jwtTokenProvider;

    public CustomerController(CustomerService customerService, JwtTokenProvider jwtTokenProvider) {
        this.customerService = customerService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@Valid @RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customerService.signUp(customer));
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody Customer customer,
                                HttpServletResponse response){

        Customer resource = customerService.findByEmail(customer);
        String token = jwtTokenProvider.createToken(resource.getEmail(),resource.getRoles());

        response.setHeader("authorization","bearer " + token);
        return ResponseEntity.ok().body("로그인 성공");
    }
}
