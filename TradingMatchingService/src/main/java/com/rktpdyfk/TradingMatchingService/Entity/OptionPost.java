package com.rktpdyfk.TradingMatchingService.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "option_post")
public class OptionPost {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_post_id")
    private long id;

    @Column(name="weapon_attack")
    private int weaponAttack;

    @Column(name="magic_attack")
    private int magicAttack;

    @Column(name="upgrade_slots")
    private int upgradeSlots;

    @Column(name="str")
    private int str;

    @Column(name="dex")
    private int dex;

    @Column(name="int")
    private int intell;

    @Column(name="luk")
    private int luk;

    @Column(name="weapon_def")
    private int weaponDef;

    @Column(name="magic_def")
    private int magicDef;

    @Column(name="speed")
    private int speed;

    @Column(name="jump")
    private int jump;

    @Column(name="dodge")
    private int dodge;

    @OneToOne(mappedBy = "optionPost", fetch = FetchType.LAZY)
    private Post post;
}
