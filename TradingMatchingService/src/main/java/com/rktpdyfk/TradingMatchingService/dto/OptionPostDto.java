package com.rktpdyfk.TradingMatchingService.dto;

import jakarta.persistence.Column;

public class OptionPostDto {
    public static class OptionPostRequestDto {
        private Long weaponAttack;
        private Long magicAttack;
        private Long upgradeSlots;
        private Long str;
        private Long dex;
        private Long intell;
        private Long luk;
        private Long weaponDef;
        private Long magicDef;
        private Long speed;
        private Long jump;
        private Long dodge;
    }
}
