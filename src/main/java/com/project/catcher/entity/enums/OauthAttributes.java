package com.project.catcher.entity.enums;

import com.project.catcher.dto.UserProfile;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

public enum OauthAttributes {

//    NAVER("naver") {
//        @Override
//        public UserProfile of(Map<String, Object> attributes) {
//            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
//            return UserProfile.builder()
//                    .oauthId((String) response.get("id"))
//                    .email((String) response.get("email"))
//                    .nickname((String) response.get("name"))
//                    .build();
//        }
//    },

    KAKAO("kakao") {
        @Override
        public UserProfile of(Map<String, Object> attributes) {
            Map<String, Object> response = (Map<String, Object>) attributes.get("response");
            return UserProfile.builder()
                    .oauthId((String) response.get("id"))
                    .email((String) response.get("account_email"))
                    .nickname((String) response.get("profile_nickname"))
                    .build();
        }
    };

    private final String providerName;

    OauthAttributes(String name) {
        this.providerName = name;
    }

    public static UserProfile extract(String providerName, Map<String, Object> attributes) {
        return Arrays.stream(values())
                .filter(provider -> providerName.equals(provider.providerName))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .of(attributes);
    }

    public abstract UserProfile of(Map<String, Object> attributes);
}
