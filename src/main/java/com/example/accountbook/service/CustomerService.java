package com.example.accountbook.service;

import com.example.accountbook.domain.Customer;
import com.example.accountbook.repository.CustomerRepository;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.NoSuchElementException;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String signUp(Customer customer){
        isEmailExist(customer);
        customerRepository.create(customer);
        return "";
    }

    private void isEmailExist(Customer resource){
        if(customerRepository.existsEmail(resource.getEmail())){
            throw new RuntimeException("이미 존재하는 아이디입니다.");
        }
    }
}
