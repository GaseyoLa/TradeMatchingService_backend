package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Job, Long> {
}
