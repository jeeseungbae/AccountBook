package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DeleteAccountRepositoryTest {

    @Autowired
    private DeleteAccountRepository deleteAccountRepository;

    @Test
    @DisplayName("성공 : 요청 정보 생성")
    public void successCreate(){
        Account resource = Account.builder()
                .id(2L)
                .customerId(1L)
                .memo("sfwwwwf")
                .payMoney(1000L)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
        deleteAccountRepository.create(resource);
    }

    @Test
    @DisplayName("성공 : 요청 정보 삭제")
    public void successDelete(){
        deleteAccountRepository.delete(1L);
    }

}