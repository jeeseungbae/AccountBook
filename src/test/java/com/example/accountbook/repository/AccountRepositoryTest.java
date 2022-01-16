package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("성공 : 가계부 생성")
    public void SuccessCreateAccount(){
        Account resource = Account.builder()
                .customerId(1L)
                .memo("sfdsf")
                .payMoney(1000L)
                .createdAt(LocalDateTime.now())
                .build();

        accountRepository.create(resource);
    }

    @Test
    @DisplayName("성공 : 가계부 수정")
    public void SuccessModifyAccount(){
        Account resource = Account.builder()
                .customerId(1L)
                .memo("sfwwwwf")
                .payMoney(1000L)
                .modifiedAt(LocalDateTime.now())
                .build();

        accountRepository.modify(resource);
    }

}