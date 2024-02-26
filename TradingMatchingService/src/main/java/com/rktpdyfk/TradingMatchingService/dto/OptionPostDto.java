package com.rktpdyfk.TradingMatchingService.dto;

import jakarta.persistence.Column;

public class OptionPostDto {
    public static class OptionPostRequestDto {
        private int weaponAttack;
        private int magicAttack;
        private int upgradeSlots;
        private int str;
        private int dex;
        private int intell;
        private int luk;
        private int weaponDef;
        private int magicDef;
        private int speed;
        private int jump;
        private int dodge;
    }
}
