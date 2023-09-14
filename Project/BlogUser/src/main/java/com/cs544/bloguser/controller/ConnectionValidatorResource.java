package com.cs544.bloguser.controller;

import com.cs544.bloguser.dto.ConnValidationResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/validateToken")
public class ConnectionValidatorResource {

    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConnValidationResponse> validatePost() {
        return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.POST.name())
                .isAuthenticated(true).build());
    }
/*
@GetMapping(value = "",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConnValidationResponse> validateGet(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        String token = (String) request.getAttribute("jwt");
        //List<GrantedAuthority> grantedAuthorities = (List<GrantedAuthority>) request.getAttribute("authorities");
        return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.GET.name())
                .username(username).token(token)
                //.authorities(grantedAuthorities)
                .isAuthenticated(true).build());
    }
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConnValidationResponse> validatePost() {
        return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.POST.name())
                .isAuthenticated(true).build());
    }

    @PostMapping(value = "/whitelisted", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConnValidationResponse> validateWhitelistedPost() {
        return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.POST.name()).build());
    }

    @GetMapping(value = "/whitelisted", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ConnValidationResponse> validateWhitelistedGet(HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        return ResponseEntity.ok(ConnValidationResponse.builder().status("OK").methodType(HttpMethod.GET.name()).username(username).build());
    }
*/
}
