package com.inflearn.kafka.service;

import com.inflearn.kafka.repository.CouponCountRepository;
import com.inflearn.kafka.repository.CouponRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
//@Transactional
class ApplyServiceTest {
    @Autowired
    ApplyService applyService;
    @Autowired
    CouponRepository couponRepository;
    @Autowired
    CouponCountRepository couponCountRepository;

    @BeforeEach
    void name() {
        couponRepository.deleteAllInBatch();
    }

//    @AfterEach
//    void after() {
//        couponRepository.deleteAllInBatch();
//    }

    @Test
    @Disabled
    void t1() throws InterruptedException {
        applyService.couponIssued(4L);


//        assertThat(count).isEqualTo(1);

        Thread.sleep(5000);  // 5초 대기

    }

    @Test
    void t2() throws InterruptedException {
        int threadCount = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(32);

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 1; i <= threadCount; i++) {
            Long userId = (long) i;
            executorService.execute(() -> {
                try {
                    applyService.couponIssued(userId);
                } finally {
                    countDownLatch.countDown();
                }
            });

        }

        countDownLatch.await();

        Thread.sleep(5000);

        couponCountRepository.reset();

        long count = couponRepository.count();
        assertThat(count).isEqualTo(1);
    }
}