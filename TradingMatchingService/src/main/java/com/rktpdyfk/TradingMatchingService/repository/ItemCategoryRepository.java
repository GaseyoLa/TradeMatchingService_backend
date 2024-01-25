package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.entity.ItemJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCategoryRepository extends JpaRepository<ItemJob, Long> {
}
