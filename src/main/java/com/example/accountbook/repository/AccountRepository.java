package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.dto.AccountDto;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    void create(Account account);

    void modify(Account account);

    void delete(Long id);

    Optional<Account> findById(Long id);

    List<AccountDto> findAll(Long customerId);
}
