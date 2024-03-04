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
@Table(name = "post")
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
    private Long incSTR;

    @Column(name = "incDEX")
    private Long incDEX;

    @Column(name = "incINT")
    private Long incINT;

    @Column(name = "incLUK")
    private Long incLUK;

    @Column(name = "incPAD")
    private Long incPAD;

    @Column(name = "incPDD")
    private Long incPDD;

    @Column(name = "incMAD")
    private Long incMAD;

    @Column(name = "incMDD")
    private Long incMDD;

    @Column(name = "incEVA")
    private Long incEVA;

    @Column(name = "incACC")
    private Long incACC;

    @Column(name = "tuc")
    private Long tuc;

    @Column(name = "price")
    private Long price;

    @Column(name = "incSpeed")
    private Long incSpeed;

    @Column(name = "incJump")
    private Long incJump;

    @Column(name = "incMHP")
    private Long incMHP;

    @Column(name = "incMMP")
    private Long incMMP;
}
