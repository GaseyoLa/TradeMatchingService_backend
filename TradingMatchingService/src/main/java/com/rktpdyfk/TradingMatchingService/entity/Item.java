package com.rktpdyfk.TradingMatchingService.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Builder
@Table(name = "item",indexes = {
        @Index(columnList = "name_kr")
})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @OneToMany(mappedBy = "item")
    private List<Post> posts; //보류

    @Column(name = "only")
    private boolean only;
    @Column(name = "cash")
    private boolean cash;
    @Column(name = "reqLevel")
    private Long reqLevel;
    @Column(name = "mob")
    private Long mob;
    @Column(name = "name_kr", unique = true) //보류
    @Size(max=30)
    private String nameKr;
    @Column(name = "name_en", unique = true) //보류
    private String nameEn;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "iconOrigin")
    private String iconOrigin;
    @Column(name = "iconRawOrigin")
    private String iconRawOrigin;
    @Column(name = "slotMax")
    private Long slotMax;
    @Column(name = "reqSTR")
    private Long reqSTR;
    @Column(name = "reqDEX")
    private Long reqDEX;
    @Column(name = "reqINT")
    private Long reqINT;
    @Column(name = "reqLUK")
    private Long reqLUK;
    @Column(name = "reqJob")
    private Long reqJob;
    @Column(name = "reqLevelEquip")
    private Long reqLevelEquip;
    @Column(name = "vslots")
    private String vslots;
    @Column(name = "islots")
    private String islots;
    @Column(name = "setCompleteCount")
    private Long setCompleteCount;
    @Column(name = "overallCategory")
    private String overallCategory;
    @Column(name = "category")
    private String category;
    @Column(name = "subCategory")
    private String subCategory;
    @Column(name = "lowItemId")
    private Long lowItemId;
    @Column(name = "highItemId")
    private Long highItemId;
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
    @Column(name = "notMHP")
    private Long incMHP;
    @Column(name = "incMMP")
    private Long incMMP;
    @Column(name = "reqPOP")
    private Long reqPOP;
    @Column(name = "attack")
    private Long attack;
    @Column(name = "attackSpeed")
    private Long attackSpeed;
    @Column(name = "recoveryHP")
    private Long recoveryHP;
    @Column(name = "recoveryMP")
    private Long recoveryMP;
}
