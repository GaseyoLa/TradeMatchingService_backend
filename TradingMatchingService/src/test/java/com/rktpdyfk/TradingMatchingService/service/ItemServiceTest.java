package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.ItemDto;
import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Test
    void 키워드_넣고_TextSearchDto_가져오기() {
        List<TextSearchDto> textSearchDto = itemService.searchItems("우산");
        org.junit.jupiter.api.Assertions.assertNotNull(textSearchDto);
        Assertions.assertThat(textSearchDto)
                .extracting(TextSearchDto::getNameKr)
                .containsExactly("노란색 우산", "하늘색 우산");
    }

    @Test
    void getItemInfo_테스트(){
        ItemDto.ItemInfoDto itemInfoDto = itemService.getItemInfoByNameKr("노란색 우산");
        Assertions.assertThat(itemInfoDto.getId()).isEqualTo(1302016);
    }
}