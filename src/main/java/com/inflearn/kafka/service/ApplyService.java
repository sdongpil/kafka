package com.inflearn.kafka.service;

import com.inflearn.kafka.repository.CouponCreateProducer;
import com.inflearn.kafka.repository.CouponCountRepository;
import com.inflearn.kafka.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCreateProducer couponCreateProducer;
    private final CouponCountRepository couponCountRepository;

    public void couponIssued(Long userId) {
        log.info("쿠폰 발급 서비스 시작");

        Long check = couponCountRepository.isCouponReceived(userId);
        if (check != 1) {
            return;
        }

        Long increment = couponCountRepository.increment();
        log.info("increment ={}", increment);

        if (increment > 100) {
            return;
        }

        couponCreateProducer.create(userId);
    }
}

