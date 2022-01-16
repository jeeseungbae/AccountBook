package com.example.accountbook.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
    @DisplayName("성공 : 회원가입 요청 2xx 응답")
    public void successSignUp() throws Exception {
        mockMvc.perform(post("/account")
                .contentType("application/json;charset=UTF-8")
                .content("{\"customerId\": 1,\"payMoney\": 2000,\"memo\": \"콜라 한잔\"}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("create"));
    }

    @Test
    @DisplayName("성공 : 수정 요청 2xx 응답")
    public void successModify() throws Exception {
        mockMvc.perform(patch("/account")
                .contentType("application/json;charset=UTF-8")
                .content("{\"id\": 1,\"customerId\": 1,\"payMoney\": 2000,\"memo\": \"wwwwdsaf\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("modify"));
    }
}