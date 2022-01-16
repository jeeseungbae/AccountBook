package com.example.accountbook.service;

import com.example.accountbook.domain.Account;
import com.example.accountbook.repository.AccountRepository;
import com.example.accountbook.repository.DeleteAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountService {

    private final DeleteAccountRepository deleteAccountRepository;

    private final AccountRepository accountRepository;

    public DeleteAccountService(DeleteAccountRepository deleteAccountRepository, AccountService accountService, AccountRepository accountRepository) {
        this.deleteAccountRepository = deleteAccountRepository;
        this.accountRepository = accountRepository;
    }

    public String delete(Long id){
        accountDataSave(id);
        deleteAccountRepository.delete(id);
        return "";
    }

    private void accountDataSave(Long id){
        Account resource = deleteAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("데이터 정보를 찾을수 없습니다."));
        accountRepository.create(resource);
    }
}
