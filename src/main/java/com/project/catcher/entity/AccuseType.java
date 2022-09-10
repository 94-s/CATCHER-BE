package com.project.catcher.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "accuse_type")
@Getter
public class AccuseType extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accuse_type_id")
    private Long id;

    @Column(name = "title")
    private String title;
}
