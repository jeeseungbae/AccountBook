package com.example.accountbook.service;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.dto.AccountDto;
import com.example.accountbook.repository.AccountRepository;
import com.example.accountbook.repository.DeleteAccountRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final DeleteAccountRepository deleteAccountRepository;

    public AccountService(AccountRepository accountRepository, DeleteAccountRepository deleteAccountRepository) {
        this.accountRepository = accountRepository;
        this.deleteAccountRepository = deleteAccountRepository;
    }

    public List<AccountDto> findAll(){
        Long customerId = 1L; // 로그인 회원 정보로 변경 수정 예정
        return accountRepository.findAll(customerId);
    }

    public Account findById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("데이터를 찾을수 없습니다."));
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
