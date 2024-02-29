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
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_name", nullable = false)
    private String name;

    @Column(name = "incSTR", columnDefinition = "boolean default false")
    private boolean incSTR;

    @Column(name = "incDEX", columnDefinition = "boolean default false")
    private boolean incDEX;

    @Column(name = "incINT", columnDefinition = "boolean default false")
    private boolean incINT;

    @Column(name = "incLUK", columnDefinition = "boolean default false")
    private boolean incLUK;

    @Column(name = "incPAD", columnDefinition = "boolean default false")
    private boolean incPAD;

    @Column(name = "incPDD", columnDefinition = "boolean default false")
    private boolean incPDD;

    @Column(name = "incMAD", columnDefinition = "boolean default false")
    private boolean incMAD;

    @Column(name = "incMDD", columnDefinition = "boolean default false")
    private boolean incMDD;

    @Column(name = "incEVA", columnDefinition = "boolean default false")
    private boolean incEVA;

    @Column(name = "incACC", columnDefinition = "boolean default false")
    private boolean incACC;

    @Column(name = "tuc", columnDefinition = "boolean default false")
    private boolean tuc;

    @Column(name = "price", columnDefinition = "boolean default false")
    private boolean price;

    @Column(name = "incSpeed", columnDefinition = "boolean default false")
    private boolean incSpeed;

    @Column(name = "incJump", columnDefinition = "boolean default false")
    private boolean incJump;

    @Column(name = "incMHP", columnDefinition = "boolean default false")
    private boolean incMHP;

    @Column(name = "incMMP", columnDefinition = "boolean default false")
    private boolean incMMP;

}
