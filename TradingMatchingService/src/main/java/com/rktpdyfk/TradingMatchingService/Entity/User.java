package com.rktpdyfk.TradingMatchingService.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users") //h2 2.x 이상버전에서는 USER 키워드 사용이 금지
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

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "discord_id")
    private String discordId;

    @Column(name = "worlds_id")
    private String worldsId;

    @Column(name = "star", nullable = true)//
    private long star;

    @Column(name = "date", nullable = true)//
    private LocalDateTime date;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

}

