package com.example.accountbook.service;

import com.example.accountbook.domain.Account;
import com.example.accountbook.repository.AccountRepository;
import com.example.accountbook.repository.DeleteAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final DeleteAccountRepository deleteAccountRepository;

    public AccountService(AccountRepository accountRepository, DeleteAccountRepository deleteAccountRepository) {
        this.accountRepository = accountRepository;
        this.deleteAccountRepository = deleteAccountRepository;
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

    public String delete(Long id){
        deleteDataSave(id);
        accountRepository.delete(id);
        return "";
    }

    private void deleteDataSave(Long id){
        Account resource = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("정보를 찾을 수 없습니다."));
        deleteAccountRepository.create(resource);
    }
}
