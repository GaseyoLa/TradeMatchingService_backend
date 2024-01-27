    package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.entity.Category;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemRepositoryTest {
    @Autowired ItemRepository itemRepository;

    @Test
    public void 쿼리문_테스트_1(){
        //아이템 이름으로 카테고리 가져오기.
        Optional<Category> category = itemRepository.findCategoryByItemName("하늘색 우산");

        assertThat(category.get().isWeaponAttack()).isEqualTo(true);
        assertThat(category.get().isWeaponDef()).isEqualTo(false);

    }
}