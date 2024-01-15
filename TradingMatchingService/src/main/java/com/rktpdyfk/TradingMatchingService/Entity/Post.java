package com.rktpdyfk.TradingMatchingService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //1대1 관계는 주인을 어디에 둬도 상관없다.
    @JoinColumn(name = "optionpost_id")
    private OptionPost optionPost;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;
}
