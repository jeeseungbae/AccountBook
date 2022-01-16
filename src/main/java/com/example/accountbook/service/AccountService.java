package com.example.accountbook.service;

import com.example.accountbook.domain.Account;
import com.example.accountbook.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public String create(Account account){
        account.setCreatedAt(LocalDateTime.now());
        accountRepository.create(account);
        return "";
    }

    public String modify(Account account){
        account.setModifiedAt(LocalDateTime.now());
        accountRepository.modify(account);
        return "";
    }
}
