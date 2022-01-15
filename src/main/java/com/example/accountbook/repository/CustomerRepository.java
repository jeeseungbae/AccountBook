package com.example.accountbook.repository;

import com.example.accountbook.domain.Customer;

public interface CustomerRepository {

    void create(Customer customer);

    boolean existsEmail(String email);

}
