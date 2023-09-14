package com.cs544.bloguser.controller;

import com.cs544.bloguser.domain.User;
import com.cs544.bloguser.dto.UserRequest;
import com.cs544.bloguser.dto.UserResponse;
import com.cs544.bloguser.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/v1/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserResponse>> getAll() {
        List<UserResponse> list = userService.getAll();
        return new ResponseEntity<List<UserResponse>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        UserResponse user = userService.getById(id);
        return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
    }

    @PutMapping(value = "/api/v1/users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {
        if (user.getId() == null || user.getId() == 0) {
            user.setId(id);
        }
        userService.SaveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PutMapping(value = "/api/v1/users/{id}/{password}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> updatePassword(@PathVariable Long id,
                                                       @PathVariable String password) {
        userService.UpdatePassword(id,password);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping(value = "/api/v1/users/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        userService.DeleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
