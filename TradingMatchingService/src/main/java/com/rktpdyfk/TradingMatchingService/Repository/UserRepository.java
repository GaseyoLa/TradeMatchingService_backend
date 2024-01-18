package com.rktpdyfk.TradingMatchingService.Repository;

import com.rktpdyfk.TradingMatchingService.Entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    //Lazy조회가 아닌 Eager조회로 auth 정보를 같이 가져옴.
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUsername(String username);
}
