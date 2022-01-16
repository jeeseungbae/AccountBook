package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;

import java.util.Optional;

public interface AccountRepository {

    void create(Account account);

    void modify(Account account);

    void delete(Long id);

    Optional<Account> findById(Long id);
}
