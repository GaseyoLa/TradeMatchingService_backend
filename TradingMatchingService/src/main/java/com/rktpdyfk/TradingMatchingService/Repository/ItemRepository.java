package com.rktpdyfk.TradingMatchingService.Repository;

import com.rktpdyfk.TradingMatchingService.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
