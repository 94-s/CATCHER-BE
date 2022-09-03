package com.project.catcher.entity;

import javax.persistence.*;

@Entity
public class Like extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "member_Id")
    private Long memberId;
}

