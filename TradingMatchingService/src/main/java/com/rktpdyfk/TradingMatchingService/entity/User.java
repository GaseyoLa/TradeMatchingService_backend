package com.rktpdyfk.TradingMatchingService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor //
@NoArgsConstructor //
@Entity
@Getter
@Builder
@Table(name = "user") //h2 2.x 이상버전에서는 USER 키워드 사용이 금지
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "discord_id")
    private String discordId;

    @Column(name = "worlds_id")
    private String worldsId;

    @Column(name = "star")//
    @Builder.Default
    private Long star = 0L;

    @Column(name = "date")//
    private LocalDateTime createDate;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }
}