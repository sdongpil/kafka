package com.inflearn.kafka.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
@NoArgsConstructor
public class Coupon extends AbstractAggregateRoot<Coupon> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    public Coupon(Long userId) {
        this.userId = userId;
    }

    public void issued() {
        registerEvent(new Coupon(userId));

    }

    @Getter
    public static class CouponCreate {
        private Long couponId;
        private Long userId;
    }
}
