package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
