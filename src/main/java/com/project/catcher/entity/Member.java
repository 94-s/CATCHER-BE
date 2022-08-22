package com.project.catcher.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "oauth_id", nullable = false)
    private String oauthId;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", length = 10, nullable = false, unique = true)
    private String nickname;

    @Column(name = "is_delete", nullable = false)
    @ColumnDefault("False")
    private Boolean isDelete;

    @Column(name = "img_url", length = 512, nullable = false)
    private String imgUrl;

    @Column(name = "created_by")
    private Long createdBy;

    protected Member(){

    }

    @Builder
    public Member(Long id, String oauthId, String email, String nickname, Boolean isDelete, String imgUrl, Long createdBy) {
        this.id = id;
        this.oauthId = oauthId;
        this.email = email;
        this.nickname = nickname;
        this.isDelete = isDelete;
        this.imgUrl = imgUrl;
        this.createdBy = createdBy;
    }

    public Member update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        return this;
    }


}
