package com.rktpdyfk.TradingMatchingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="weapon_attack", columnDefinition = "boolean default false")
    private boolean weaponAttack;

    @Column(name="magic_attack", columnDefinition = "boolean default false")
    private boolean magicAttack;

    @Column(name="upgrade_slots", columnDefinition = "boolean default false")
    private boolean upgradeSlots;

    @Column(name="str", columnDefinition = "boolean default false")
    private boolean str;

    @Column(name="dex", columnDefinition = "boolean default false")
    private boolean dex;

    @Column(name="int", columnDefinition = "boolean default false")
    private boolean intell;

    @Column(name="luk", columnDefinition = "boolean default false")
    private boolean luk;

    @Column(name="weapon_def", columnDefinition = "boolean default false")
    private boolean weaponDef;

    @Column(name="magic_def", columnDefinition = "boolean default false")
    private boolean magicDef;

    @Column(name="speed", columnDefinition = "boolean default false")
    private boolean speed;

    @Column(name="jump", columnDefinition = "boolean default false")
    private boolean jump;

    @Column(name="dodge", columnDefinition = "boolean default false")
    private boolean dodge;

    @OneToMany(mappedBy = "category")
    private List<Category> categories = new ArrayList<>();


}
