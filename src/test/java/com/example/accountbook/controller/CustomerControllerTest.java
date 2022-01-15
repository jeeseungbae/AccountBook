package com.example.accountbook.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("성공 : 회원가입")
    public void SuccessSignUp() throws Exception {
        mockMvc.perform(post("/project/sign-up")
                    .contentType("application/json")
                    .content("{\"email\": \"sdfwf@naver.com\",\"password\": \"12321j5432\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 비밀번호 없음")
    public void failSignUpPasswordEmpty() throws Exception {
        mockMvc.perform(post("/project/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"wefjkl@naver.com\",\"password\": \"\"}"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 비밀번호 개수 5개")
    public void failSignUpPasswordSize() throws Exception {
        mockMvc.perform(post("/project/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"wefjkl@naver.com\",\"password\": \"12345\"}"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 회원가입 - 이메일 없음")
    public void failSignUpEmailEmpty() throws Exception {
        mockMvc.perform(post("/project/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"\",\"password\": \"12341g234\"}"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 회원가입 - @ 없음")
    public void failSignUpEmailStructure() throws Exception {
        mockMvc.perform(post("/project/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"acom\",\"password\": \"12341g234\"}"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

}