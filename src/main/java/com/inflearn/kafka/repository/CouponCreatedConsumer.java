package com.inflearn.kafka.repository;

import com.inflearn.kafka.domain.Coupon;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CouponCreatedConsumer {
    private final CouponRepository couponRepository;

    @KafkaListener(topics = "create-coupon", groupId = "group_1")
    public void listener(Long userId) {
        try {

            couponRepository.save(new Coupon(userId));

        } catch (Exception e) {
            log.error("쿠폰 생성 실패 - userId: {}", userId, e);
            throw new RuntimeException("쿠폰 생성 실패", e);
        }
    }
}
