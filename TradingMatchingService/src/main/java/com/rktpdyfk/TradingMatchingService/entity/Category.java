package com.rktpdyfk.TradingMatchingService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name="weapon_attack")
    private boolean weaponAttack;

    @Column(name="magic_attack")
    private boolean magicAttack;

    @Column(name="upgrade_slots")
    private boolean upgradeSlots;

    @Column(name="str")
    private boolean str;

    @Column(name="dex")
    private boolean dex;

    @Column(name="int")
    private boolean intell;

    @Column(name="luk")
    private boolean luk;

    @Column(name="weapon_def")
    private boolean weaponDef;

    @Column(name="magic_def")
    private boolean magicDef;

    @Column(name="speed")
    private boolean speed;

    @Column(name="jump")
    private boolean jump;

    @Column(name="dodge")
    private boolean dodge;


}
