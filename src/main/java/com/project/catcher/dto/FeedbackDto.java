package com.project.catcher.dto;

import com.project.catcher.entity.Feedback;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FeedbackDto {

    private Long id;

    private String content;

    private String leaveReason;

    @Builder
    public Feedback toEntity(Long id, String content, String leaveReason) {
        return Feedback.builder()
                .id(id)
                .content(content)
                .leaveReason(leaveReason)
                .build();
    }
}
