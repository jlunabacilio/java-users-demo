package com.demo;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@WebMvcTest
@AutoConfigureMockMvc

public class UsersControllerTest{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersRepository repository;

    // generate a test for create user method
    @Test
    public void testCreateUser() throws Exception{
        Users user = new Users("John Doe", true);
        when(repository.save(any(Users.class))).thenReturn(user);

        mockMvc.perform(post("/users")
            .content(new ObjectMapper().writeValueAsString(user))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.fullname").value("John Doe"));
    }

}