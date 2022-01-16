package com.example.accountbook.controller;

import com.example.accountbook.service.DeleteAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete-accounts")
public class DeleteAccountController {

    private final DeleteAccountService deleteAccountService;

    public DeleteAccountController(DeleteAccountService deleteAccountService) {
        this.deleteAccountService = deleteAccountService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(deleteAccountService.delete(id));
    }
}
