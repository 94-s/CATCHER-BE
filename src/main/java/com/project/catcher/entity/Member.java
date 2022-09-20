package com.project.catcher.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "nickname", length = 10, nullable = false, unique = true)
    private String nickname;

    @Column(name = "oauth_id", nullable = false)
    private String oauthId;

    @Column(name = "is_delete", nullable = false)
    @ColumnDefault("False")
    private Boolean isDelete;

    @Column(name = "img_url", length = 512, nullable = false)
    private String imgUrl;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "buyer_name", length = 20)
    private String buyerName;

    @Column(name = "buyer_address", length = 50)
    private String buyerAddress;

    @Column(name = "buyer_phone", length = 20)
    private String buyerPhone;

    @Column(name = "account_holder", length = 20)
    private String accountHolder;

    @Column(name = "account_bank", length = 20)
    private String accountBank;

    @Column(name = "account_number", length = 30)
    private String accountNumber;

    protected Member(){

    }

    @Builder
    public Member(Long id, String oauthId, String email, String nickname, Boolean isDelete, String imgUrl) {
        this.id = id;
        this.oauthId = oauthId;
        this.email = email;
        this.nickname = nickname;
        this.isDelete = isDelete;
        this.imgUrl = imgUrl;
    }

    public Member update(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
        return this;
    }


}
