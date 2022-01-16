package com.example.accountbook.repository;

import com.example.accountbook.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {

    void create(Customer customer);

    boolean existsEmail(String email);

    Optional<Customer> findByEmail(String email);

}
