package com.project.catcher.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginResponse {

    private Long id;
    private String nickname;
    private String email;
    private String tokenType;
    private String accessToken;
    private String refreshToken;

    @Builder
    public LoginResponse(Long id, String nickname, String email, String tokenType, String accessToken, String refreshToken) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.tokenType = tokenType;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
