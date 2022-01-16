package com.example.accountbook.controller;

import com.example.accountbook.domain.Account;
import com.example.accountbook.domain.dto.AccountDto;
import com.example.accountbook.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<String> create(@Valid @RequestBody Account account){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountService.create(account));
    }

    @PatchMapping("")
    public ResponseEntity<String> modify(@Valid @RequestBody Account account){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.modify(account));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.delete(id));
    }

}
