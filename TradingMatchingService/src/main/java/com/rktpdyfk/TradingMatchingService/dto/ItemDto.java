package com.rktpdyfk.TradingMatchingService.dto;

import com.rktpdyfk.TradingMatchingService.entity.Item;
import lombok.*;

public class ItemDto {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ItemInfoDto {
        private Long id;
        private boolean only;
        private boolean cash;
        private Long reqLevel;
        private Long mob;
        private String nameKr;
        private String nameEn;
        private String description;
        private String image;
        private String iconOrigin;
        private String iconRawOrigin;
        private Long slotMax;
        private Long reqSTR;
        private Long reqDEX;
        private Long reqINT;
        private Long reqLUK;
        private Long reqJob;
        private Long reqLevelEquip;
        private String vslots;
        private String islots;
        private Long setCompleteCount;
        private String overallCategory;
        private String category;
        private String subCategory;
        private Long lowItemId;
        private Long highItemId;
        private Long incSTR;
        private Long incDEX;
        private Long incINT;
        private Long incLUK;
        private Long incPAD;
        private Long incPDD;
        private Long incMAD;
        private Long incMDD;
        private Long incEVA;
        private Long incACC;
        private Long tuc;
        private Long price;
        private Long incSpeed;
        private Long incJump;
        private Long incMHP;
        private Long incMMP;
        private Long reqPOP;
        private Long attack;
        private Long attackSpeed;
        private Long recoveryHP;
        private Long recoveryMP;

        public ItemInfoDto(Item item) {
            this.id = item.getId();
            this.only = item.isOnly();
            this.cash = item.isCash();
            this.reqLevel = item.getReqLevel();
            this.mob = item.getMob();
            this.nameKr = item.getNameKr();
            this.nameEn = item.getNameEn();
            this.description = item.getDescription();
            this.image = item.getImage();
            this.iconOrigin = item.getIconOrigin();
            this.iconRawOrigin = item.getIconRawOrigin();
            this.slotMax = item.getSlotMax();
            this.reqSTR = item.getReqSTR();
            this.reqDEX = item.getReqDEX();
            this.reqINT = item.getReqINT();
            this.reqLUK = item.getReqLUK();
            this.reqJob = item.getReqJob();
            this.reqLevelEquip = item.getReqLevelEquip();
            this.vslots = item.getVslots();
            this.islots = item.getIslots();
            this.setCompleteCount = item.getSetCompleteCount();;
            this.overallCategory = item.getOverallCategory();
            this.category = item.getCategory();
            this.subCategory = item.getSubCategory();
            this.lowItemId = item.getLowItemId();
            this.highItemId = item.getHighItemId();
            this.incSTR = item.getIncSTR();
            this.incDEX = item.getIncDEX();
            this.incINT = item.getIncINT();
            this.incLUK = item.getIncLUK();
            this.incPAD = item.getIncPAD();
            this.incPDD = item.getIncPDD();
            this.incMAD = item.getIncMAD();
            this.incMDD = item.getIncMDD();
            this.incEVA = item.getIncEVA();
            this.incACC = item.getIncACC();
            this.tuc = item.getTuc();
            this.price = item.getPrice();
            this.incSpeed = item.getIncSpeed();
            this.incJump = item.getIncJump();
            this.incMHP = item.getIncMHP();
            this.incMMP = item.getIncMMP();
            this.reqPOP = item.getReqPOP();
            this.attack = item.getAttack();
            this.attackSpeed = item.getAttackSpeed();
            this.recoveryHP = item.getRecoveryHP();
            this.recoveryMP = item.getRecoveryMP();
        }
    }
}
