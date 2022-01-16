package com.example.accountbook.service;

import com.example.accountbook.domain.Customer;
import com.example.accountbook.domain.dto.CustomerDto;
import com.example.accountbook.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String signUp(Customer customer){
        isEmailExist(customer.getEmail());
        customer.setRoles("ROLE_USER");
        customerRepository.create(customer);
        return "";
    }

    private void isEmailExist(String email){
        if(customerRepository.existsEmail(email)){
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }
    }

    public Customer findByEmail(Customer customer){
        return customerRepository.findByEmail(customer.getEmail())
                .orElseThrow(()-> new RuntimeException("정보를 찾을수 없습니다."));
    }
}
