package com.project.catcher.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Feedback extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long id;

    @Column(name = "content", length = 2500)
    private String content;

    @Column(name = "leave_reason", length = 2500)
    private String leaveReason;

    @Builder
    public Feedback(Long id, String content, String leaveReason) {
        this.id = id;
        this.content = content;
        this.leaveReason = leaveReason;
    }
}
