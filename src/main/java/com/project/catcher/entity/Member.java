package com.project.catcher.entity;

import com.project.catcher.entity.enums.SocialType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "nickname", length = 10, nullable = false, unique = true)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name = "social_login_type", length = 20, nullable = false)
    private SocialType socialLoginType;

    @Column(name = "is_delete", nullable = false)
    @ColumnDefault("False")
    private Boolean isDelete;

    @Column(name = "img_url", length = 512, nullable = false)
    private String imgUrl;

    @Column(name = "created_by")
    private Long createdBy;


}
