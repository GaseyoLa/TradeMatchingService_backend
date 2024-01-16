package com.rktpdyfk.TradingMatchingService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users") //h2 2.x 이상버전에서는 USER 키워드 사용이 금지
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "login_id", nullable = false)
    private String loginId;

    @Column(name = "discord_id")
    private String discordId;

    @Column(name = "worlds_id")
    private String worldsId;

    @Column(name = "star", nullable = false)
    private long star;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

}
