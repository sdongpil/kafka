package com.inflearn.kafka.event;

import com.inflearn.kafka.domain.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventHandler {

    @EventListener
    public void handleCouponCreated(Coupon.CouponCreate event) {

    }
}
