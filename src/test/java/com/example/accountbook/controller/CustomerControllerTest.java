package com.example.accountbook.controller;

import com.example.accountbook.config.JwtTokenProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private String token;

    @BeforeEach
    public void init(){
        token = "Bearer " + jwtTokenProvider.createToken("sljdfs@naver.com","ROLE_USER");
    }

    @Test
    @DisplayName("성공 : 요청 2xx 응답")
    public void SuccessSignUp() throws Exception {
        mockMvc.perform(post("/customer/sign-up")
                    .contentType("application/json")
                    .content("{\"email\": \"sdfwf@naver.com\",\"password\": \"12dfgd5432\"}")
                    .header("authorization",token))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 4xx 비밀번호 없음")
    public void failSignUpPasswordEmpty() throws Exception {
        mockMvc.perform(post("/customer/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"wefjkl@naver.com\",\"password\": \"\"}")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 4xx 비밀번호 개수 5개")
    public void failSignUpPasswordSize() throws Exception {
        mockMvc.perform(post("/customer/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"wefjkl@naver.com\",\"password\": \"12345\"}")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 4xx 회원가입 - 이메일 없음")
    public void failSignUpEmailEmpty() throws Exception {
        mockMvc.perform(post("/customer/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"\",\"password\": \"12341g234\"}")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

    @Test
    @DisplayName("실패 : 4xx 회원가입 - @ 없음")
    public void failSignUpEmailStructure() throws Exception {
        mockMvc.perform(post("/customer/sign-up")
                .contentType("application/json")
                .content("{\"email\":\"acom\",\"password\": \"12341g234\"}")
                .header("authorization",token))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(handler().handlerType(CustomerController.class))
                .andExpect(handler().methodName("signUp"));
    }

}