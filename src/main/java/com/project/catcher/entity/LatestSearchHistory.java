package com.project.catcher.entity;

import javax.persistence.*;

@Entity
public class LatestSearchHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "latest_search_history_id")
    private Long id;

    @Column(name = "query", length = 50)
    private String query;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member memberId;
}
