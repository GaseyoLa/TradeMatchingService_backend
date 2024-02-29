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

    @ManyToOne
    @JoinColumn(name = "category", insertable = false, updatable = false, nullable = true)
    private Category category;

    @OneToMany(mappedBy = "item")
    private List<Post> posts; //보류

    @Column(name = "only")
    private boolean only;
    @Column(name = "cash")
    private boolean cash;
    @Column(name = "reqLevel")
    private int reqLevel;
    @Column(name = "mob")
    private int mob;
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
    private int slotMax;
    @Column(name = "reqSTR")
    private int reqSTR;
    @Column(name = "reqDEX")
    private int reqDEX;
    @Column(name = "reqINT")
    private int reqINT;
    @Column(name = "reqLUK")
    private int reqLUK;
    @Column(name = "reqJob")
    private int reqJob;
    @Column(name = "reqLevelEquip")
    private int reqLevelEquip;
    @Column(name = "vslots")
    private String vslots;
    @Column(name = "islots")
    private String islots;
    @Column(name = "setCompleteCount")
    private int setCompleteCount;
    @Column(name = "overallCategory")
    private String overallCategory;
//    @Column(name = "category")
//    private String category_str;
    @Column(name = "subCategory")
    private String subCategory;
    @Column(name = "lowItemId")
    private int lowItemId;
    @Column(name = "highItemId")
    private int highItemId;
    @Column(name = "incSTR")
    private int incSTR;
    @Column(name = "incDEX")
    private int incDEX;
    @Column(name = "incINT")
    private int incINT;
    @Column(name = "incLUK")
    private int incLUK;
    @Column(name = "incPAD")
    private int incPAD;
    @Column(name = "incPDD")
    private int incPDD;
    @Column(name = "incMAD")
    private int incMAD;
    @Column(name = "incMDD")
    private int incMDD;
    @Column(name = "incEVA")
    private int incEVA;
    @Column(name = "incACC")
    private int incACC;
    @Column(name = "tuc")
    private int tuc;
    @Column(name = "tradeBlock")
    private String tradeBlock;
    @Column(name = "price")
    private int price;
    @Column(name = "incSpeed")
    private int incSpeed;
    @Column(name = "incJump")
    private int incJump;
    @Column(name = "notSale")
    private String notSale;
    @Column(name = "incMHP")
    private int incMHP;
    @Column(name = "incMMP")
    private int incMMP;
    @Column(name = "reqPOP")
    private int reqPOP;
    @Column(name = "incCraft")
    private int incCraft;
    @Column(name = "nameTagId")
    private int nameTagId;
    @Column(name = "chatBalloonId")
    private int chatBalloonId;
    @Column(name = "attack")
    private int attack;
    @Column(name = "attackSpeed")
    private int attackSpeed;
    @Column(name = "androidGrade")
    private int androidGrade;
    @Column(name = "recoveryHP")
    private int recoveryHP;
    @Column(name = "recoveryMP")
    private int recoveryMP;
    @Column(name = "monsterBook")
    private String monsterBook;

}
