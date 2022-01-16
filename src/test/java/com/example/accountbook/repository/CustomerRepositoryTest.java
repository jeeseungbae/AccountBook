package com.example.accountbook.repository;

import com.example.accountbook.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("성공 : 데이터 생성")
    public void SuccessCreate(){
        Customer customer = Customer.builder()
                .email("sdfsef@naver.com")
                .password("1234532")
                .roles("ROLE_USER")
                .build();
        customerRepository.create(customer);
    }

    @Test
    @DisplayName("성공 : email 존재 여부")
    public void SuccessExistsEmail(){
        Customer customer = Customer.builder()
                .email("sdfsef@naver.com")
                .password("1234532")
                .roles("ROLE_USER")
                .build();
        customerRepository.create(customer);

        Assertions.assertTrue(customerRepository.existsEmail(customer.getEmail()));
    }

}