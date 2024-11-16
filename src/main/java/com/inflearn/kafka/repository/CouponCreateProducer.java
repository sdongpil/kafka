package com.inflearn.kafka.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CouponCreateProducer {
    private static final String TOPIC_NAME = "create-coupon";

    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void create(Long userId) {
        try {

            kafkaTemplate.send(TOPIC_NAME, userId);

        } catch (Exception e) {
            log.error("메시지 발행 실패 - userId: {}", userId, e);
            throw new RuntimeException("Kafka 메시지 발행 실패", e);
        }
    }

}
