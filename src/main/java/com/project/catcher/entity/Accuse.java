package com.project.catcher.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Accuse extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accuse_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accuse_type_id")
    private AccuseType accuseType;

    @ManyToOne
    @JoinColumn(name = "accused_id")
    private Member accusedMember;

    @Column(name = "content")
    private String content;

}
