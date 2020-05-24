package com.boyarsky.protocolengine.controller.v1;

import com.boyarsky.protocolengine.service.ProtocolHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
class ProtocolControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProtocolHandler handler;

    @Test
    void handle() throws Exception {
        mockMvc.perform(post("/v1/protocols")).andDo(print());
    }
}