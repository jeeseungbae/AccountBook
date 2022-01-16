package com.example.accountbook.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeleteAccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("성공 : 데이터 복구 완료")
    public void dataDeleteAccount() throws Exception {
        mockMvc.perform(delete("/delete-accounts/1")
                .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(DeleteAccountController.class))
                .andExpect(handler().methodName("delete"));
    }
}