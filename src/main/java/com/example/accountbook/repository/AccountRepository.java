package com.example.accountbook.repository;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.Customer;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository {

    void create(Account account);

    void modify(Account account);

    Optional<Account> findById(Long id);
}
