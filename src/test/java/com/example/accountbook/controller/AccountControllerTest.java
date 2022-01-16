package com.example.accountbook.controller;

import com.example.accountbook.config.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private String token;

    @BeforeEach
    public void init(){
        token = "Bearer " + jwtTokenProvider.createToken("sljdfs@naver.com","ROLE_USER");
    }

    @Test
    @DisplayName("성공 : 회원가입 요청 2xx 응답")
    public void successSignUp() throws Exception {
        mockMvc.perform(post("/accounts")
                .contentType("application/json;charset=UTF-8")
                .content("{\"customerId\": 1,\"payMoney\": 2000,\"memo\": \"콜라 한잔\"}")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("create"));
    }

    @Test
    @DisplayName("성공 : 데이터 수정 요청 2xx 응답")
    public void successModify() throws Exception {
        mockMvc.perform(patch("/accounts")
                .contentType("application/json;charset=UTF-8")
                .content("{\"id\": 1,\"customerId\": 1,\"payMoney\": 2000,\"memo\": \"wwwwdsaf\"}")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("modify"));
    }

    @Test
    @DisplayName("성공 : 데이터 삭제 요청 2xx 응답")
    public void successDelete() throws Exception {
        mockMvc.perform(delete("/accounts/2")
                .contentType("application/json;charset=UTF-8")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("delete"));
    }

    @Test
    @DisplayName("성공 : 자세한 정보 요청 2xx 응답")
    public void successFindById() throws Exception {
        mockMvc.perform(get("/accounts/2")
                .contentType("application/json;charset=UTF-8")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("findById"));
    }

    @Test
    @DisplayName("성공 : 가계부 리스트 요청 2xx 응답")
    public void successFindAll() throws Exception {
        mockMvc.perform(get("/accounts/all")
                .contentType("application/json;charset=UTF-8")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(AccountController.class))
                .andExpect(handler().methodName("findAll"));
    }
}