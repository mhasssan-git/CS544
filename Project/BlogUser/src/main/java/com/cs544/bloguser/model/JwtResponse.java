package com.cs544.bloguser.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class JwtResponse   {
    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }
}
