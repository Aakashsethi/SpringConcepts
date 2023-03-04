package com.NoshVersion01.controller;

import com.NoshVersion01.modeOrDto.UserRegistrationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/UserRegistration")
public class UserRegistrationController {
    private Map<String, UserRegistrationDTO> userDatabase = new HashMap<>();

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        if (userDatabase.containsKey(userRegistrationDTO.getEmail())) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }

        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return new ResponseEntity<>("Passwords do not match", HttpStatus.BAD_REQUEST);
        }

        // Add the user to the database
        userDatabase.put(userRegistrationDTO.getEmail(), userRegistrationDTO);

        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
       // return null;
    }

}
