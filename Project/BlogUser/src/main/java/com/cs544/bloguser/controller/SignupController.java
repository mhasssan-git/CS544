package com.cs544.bloguser.controller;

import com.cs544.bloguser.dto.UserRequest;
import com.cs544.bloguser.dto.UserResponse;
import com.cs544.bloguser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/signup")
public class SignupController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addUser(@RequestBody UserRequest userRequest) {
        userService.SaveUser(userRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
