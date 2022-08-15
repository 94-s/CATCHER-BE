package com.project.catcher.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "accuse_type")
@Getter
@Setter
public class AccuseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accuse_type_id")
    private Long id;

    @Column(name = "title")
    private String title;
}
