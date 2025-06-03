package com.example.auth_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

import java.util.Set;

@Data
public class AuthResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("name")
    private String name;

    public AuthResponse(String accessToken, String refreshToken, Long id, String email, String name) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.id = id;
        this.email = email;
        this.name = name;

    }


}
