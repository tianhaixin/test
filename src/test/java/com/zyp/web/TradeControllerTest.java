package com.zyp.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.zyp.service.ShipmentService;

public class TradeControllerTest {
    
    private static final String AUTHORIZATION = "Authorization";

    private MockMvc mvc;

    @Mock
    // mock被测类中依赖的对象
    private ShipmentService service;

    @InjectMocks
    private TradeController controller;

    @Before
    public void setup() {
        // 初始化
        MockitoAnnotations.initMocks(this);
        // 构建mvc环境
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    // @Test
    public void testAddSuccess() throws Exception {
        mvc.perform(post("/trades").header(AUTHORIZATION, "123").contentType(MediaType.APPLICATION_JSON)
                .content("{\"trade\":{\"quantity\":250},\"shipmentList\":[{\"seq\":1,\"quantity\":250}]}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddBadParam() throws Exception {
        mvc.perform(post("/trades").header(AUTHORIZATION, "123").contentType(MediaType.APPLICATION_JSON)
                .content("{\"trade\":{},\"shipmentList\":[{\"seq\":1,\"quantity\":250}]}"))
                .andExpect(status().isBadRequest());
    }
}
