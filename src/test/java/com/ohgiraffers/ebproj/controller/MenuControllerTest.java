package com.ohgiraffers.ebproj.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

/* 가상의 요청(request)을 테스트 하기 위한 Mock객체 테스트용 설정(요청, 전송, 응답) */
@AutoConfigureMockMvc
class MenuControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("상태확인")
    @Test
    public void healthCheckTest() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("4번 메뉴 확인")
    @Test
    public void findMenuCodeTest() throws Exception{
        mockMvc.perform(get("/menus/4"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.menuName").value("갈릭미역파르페"))
                .andDo(print());
    }
}