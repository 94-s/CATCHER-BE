package com.project.catcher.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "latest_search_history")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LatestSearchHistory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "latest_search_history_id")
    private Long id;

    @Column(name = "query", length = 50)
    private String query;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member memberId;
}
