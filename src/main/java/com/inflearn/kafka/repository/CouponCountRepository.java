package com.inflearn.kafka.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CouponCountRepository {

    private final RedisTemplate<String, String> redisTemplate;

    public Long increment() {
        return redisTemplate.opsForValue().increment("coupon-count");
    }

    public void reset() {
        redisTemplate.opsForValue().set("coupon-count", "0");
    }

    public Long isCouponReceived(Long userId) {
        return redisTemplate.opsForSet().add("user", userId.toString());
    }

}
