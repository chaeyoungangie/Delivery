package com.example.Delivery;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired MockMvc mvc;
    @Autowired ObjectMapper mapper;

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @Test
    void save_test() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjc1ODM3MTc4LCJleHAiOjE2NzU4Mzg2MTh9.tlmw_jiJzCtQMoWFAOQ_OgzxQ1gQ8Bmu7369m7nCNoU ";
       
        
        // mvc.perform(MockMvcRequestBuilders.get("/api/v1/users/getAccount")
        // .contentType(MediaType.APPLICATION_JSON)
        // .content("{\"token\": \"4532756279624064\"}"))
        // .andExpect(MockMvcResultMatchers.status().isOk())
        // .andExpect(MockMvcResultMatchers.model().attribute("token", token_))
        // .andDo(MockMvcResultHandlers.print());

        mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/users/test")
                .header("Authorization", "Bearer " + token)
                // .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                // .andDo( print() )
                .andExpect(status().isOk());

    }


}
