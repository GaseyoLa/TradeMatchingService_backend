package com.rktpdyfk.TradingMatchingService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "posts")
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @Column(name = "date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "incSTR")
    private int incSTR;

    @Column(name = "incDEX")
    private int incDEX;

    @Column(name = "incINT")
    private int incINT;

    @Column(name = "incLUK")
    private int incLUK;

    @Column(name = "incPAD")
    private int incPAD;

    @Column(name = "incPDD")
    private int incPDD;

    @Column(name = "incMAD")
    private int incMAD;

    @Column(name = "incMDD")
    private int incMDD;

    @Column(name = "incEVA")
    private int incEVA;

    @Column(name = "incACC")
    private int incACC;

    @Column(name = "tuc")
    private int tuc;

    @Column(name = "price")
    private int price;

    @Column(name = "incSpeed")
    private int incSpeed;

    @Column(name = "incJump")
    private int incJump;

    @Column(name = "incMHP")
    private int incMHP;

    @Column(name = "incMMP")
    private int incMMP;
}
