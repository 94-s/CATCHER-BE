package com.project.catcher.entity;


import javax.persistence.*;

@Entity
public class Accuse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accuse_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accuse_type_id")
    private AccuseType accuseType;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Member createdBy;

    @ManyToOne
    @JoinColumn(name = "accused_id")
    private Member accusedMember;

    @Column(name = "content")
    private String content;


}
