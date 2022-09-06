package com.project.catcher.entity;

import com.project.catcher.entity.enums.TransactStatus;
import com.project.catcher.entity.enums.TransactType;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Transact extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transact_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type", length = 50)
    private TransactType type;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status", length = 45)
    private TransactStatus status;

    @Column(name = "tracking_number", length = 30)
    private String trackingNumber;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private Member seller;

    @OneToOne
    @JoinColumn(name = "buyer_id")
    private Member buyer;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "promise_date")
    private LocalDateTime promiseDate;

}
