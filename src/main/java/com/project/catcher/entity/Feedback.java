package com.project.catcher.entity;

import javax.persistence.*;

@Entity
public class Feedback extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long id;

    @Column(name = "content", length = 2500)
    private String content;

    @Column(name = "leave_reason", length = 2500)
    private String leaveReason;
}
