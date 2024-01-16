package com.rktpdyfk.TradingMatchingService.Repository;

import com.rktpdyfk.TradingMatchingService.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
