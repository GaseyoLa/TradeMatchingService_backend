package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Category;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    //아이템 이름으로 카테고리 객체 가져오기.
//    @Query("SELECT i.category FROM Item i WHERE i.nameKr = :itemName")
//    Optional<Category> findCategoryByItemName(@Param("itemName") String itemName);

    //TextSearch용
    @Query("SELECT i FROM Item i WHERE i.nameKr LIKE CONCAT('%',:keyword,'%')")
    List<Item> findItemListByKeyword(@Param("keyword") String keyword);

}