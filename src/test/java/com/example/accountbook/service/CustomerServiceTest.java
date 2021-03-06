package com.example.accountbook.service;

import com.example.accountbook.domain.Customer;
import com.example.accountbook.domain.dto.CustomerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("성공 : 이메일 체크 후 데이터 생성")
    public void SuccessSignUp(){
        Customer resource = Customer.builder()
                .email("email@naver.com")
                .password("2jkl324")
                .roles("ROLE_USER")
                .build();
        customerService.signUp(resource);

        Assertions.assertThrows(RuntimeException.class,
                ()->customerService.signUp(resource));
    }

}