package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
