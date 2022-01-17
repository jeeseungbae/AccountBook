package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.dto.AccountDetailDto;
import com.example.accountbook.domain.dto.AccountDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    @Test
    @DisplayName("성공 : 가계부 삭제")
    public void SuccessDeleteAccount(){
        Long id = 1L;
        accountRepository.delete(id);
    }

    @Test
    @DisplayName("성공 : 가계부 조회")
    public void SuccessFindById(){
        Long id = 2L;
        Optional<Account> account = accountRepository.findById(id);
        Assertions.assertTrue(account.isPresent());

        account.ifPresent(select->{
            Assertions.assertEquals(id,select.getId());
        });
    }

    @Test
    @DisplayName("성공 : 가계부 전부 조회")
    public void successFindAll(){
        Long id = 2L;
        List<AccountDto> accountDtos = accountRepository.findAll(id);

        for(AccountDto accountDto : accountDtos){
            Assertions.assertEquals(accountDto.getId(),id);
        }

    }

}