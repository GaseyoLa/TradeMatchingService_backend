package com.rktpdyfk.TradingMatchingService.redis;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Redis는 JpaRepository 대신 CrudRepository를 상속받아서 사용한다.
public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByAuthId(String authId);
}
