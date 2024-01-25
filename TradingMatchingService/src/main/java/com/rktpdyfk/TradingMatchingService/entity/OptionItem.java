package com.rktpdyfk.TradingMatchingService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Table(name = "option_item")
public class OptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_item_id")
    private Long id;

    @Column(name = "job")
    private String job;

    @Column(name = "weapon_attack")
    private Integer weaponAttack;

    @Column(name = "magic_attack")
    private Integer magicAttack;

    @Column(name = "required_level")
    private Integer requiredLevel;

    @Column(name = "required_stat")
    private String requiredStat;

    @Column(name = "attack_speed")
    private Integer attackSpeed;

    @Column(name = "upgrade_slots")
    private Integer upgradeSlots;

    @Column(name = "sells_for")
    private Integer sellsFor;

    @Column(name = "equip_group")
    private String equipGroup;

    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    private String subCategory;

    @Column(name = "overall_category")
    private String overallCategory;

    @Column(name = "weapon_def")
    private Integer weaponDef;

    @Column(name = "magic_def")
    private Integer magicDef;

    @Column(name = "effects", length = 50)
    private String effects;

    @OneToOne(mappedBy = "optionItem", fetch = FetchType.LAZY) //mappedBy??
    private Item item;

}
