package com.example.accountbook.controller;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.Customer;
import com.example.accountbook.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountService.create(account));
    }

    @PatchMapping("")
    public ResponseEntity<String> modify(@RequestBody Account account){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.modify(account));
    }

}
