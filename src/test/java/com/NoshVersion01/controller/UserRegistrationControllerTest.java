package com.NoshVersion01.controller;

import com.NoshVersion01.modeOrDto.UserRegistrationDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRegistrationController userRegistrationController;

    @Test
    public void testSignup() throws Exception {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userRegistrationController).build();
        userRegistrationDTO.setFirstName("John");
        userRegistrationDTO.setLastName("Doe");
        userRegistrationDTO.setEmail("john.doe@example.com");
        userRegistrationDTO.setPassword("password");
        userRegistrationDTO.setConfirmPassword("password");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/UserRegistration/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Test\",\"lastName\":\"User\",\"email\":\"test@example.com\",\"password\":\"password\",\"confirmPassword\":\"password\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("User created successfully"))
                .andDo(print());
    }
}