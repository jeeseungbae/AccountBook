package com.example.accountbook.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("성공 : 요청 2xx 응답")
    public void SuccessSignUp() throws Exception {
        mockMvc.perform(post("/account")
                .contentType("application/json;charset=UTF-8")
                .content("{\"customerId\": 1,\"payMoney\": 2000,\"memo\": \"콜라 한잔\"}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("create"));
    }
}