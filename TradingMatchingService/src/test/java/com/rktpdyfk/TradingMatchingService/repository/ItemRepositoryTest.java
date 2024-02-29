    package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Category;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired ItemRepository itemRepository;

    @Test
    void 쿼리문_테스트_1(){

        Optional<Category> category = itemRepository.findCategoryByItemName("하늘색 우산");

        assertThat(category.get().isIncPAD()).isEqualTo(true);
        assertThat(category.get().isIncPDD()).isEqualTo(false);
    }

    @Test
    void findByKeyword_Test() {
        List<Item> items = itemRepository.findByKeyword("우산");

        org.junit.jupiter.api.Assertions.assertNotNull(items);
        Assertions.assertThat(items)
                .extracting(Item::getNameKr)
                .containsExactly("하늘색 우산","노란색 우산");
    }
}