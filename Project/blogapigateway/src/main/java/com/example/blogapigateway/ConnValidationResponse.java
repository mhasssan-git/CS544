package com.example.blogapigateway;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class ConnValidationResponse {
    private String status;
    private boolean isAuthenticated;
    private String methodType;
    private String username;
    private List<GrantedAuthority> authorities;
}
@NoArgsConstructor
class GrantedAuthority
{

}
