package com.rktpdyfk.TradingMatchingService.Repository;

import com.rktpdyfk.TradingMatchingService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
