package com.project.catcher.dto;

import com.project.catcher.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
public class UserProfile {

    private final String oauthId;
    private final String nickname;
    private final String email;

    @Builder
    public UserProfile(String oauthId, String nickname, String email) {
        this.oauthId = oauthId;
        this.nickname = nickname;
        this.email = email;
    }

    public Member toMember() {
        return Member.builder()
                .oauthId(oauthId)
                .email(email)
                .nickname(nickname)
                .imgUrl("a")
                .isDelete(false)
                .createdBy(1L)
                .build();
    }


}
