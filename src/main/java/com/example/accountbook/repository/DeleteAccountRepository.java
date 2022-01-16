package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;

import java.util.Optional;

public interface DeleteAccountRepository {

    void create(Account account);

    Optional<Account> findById(Long id);

    void delete(Long id);
}
