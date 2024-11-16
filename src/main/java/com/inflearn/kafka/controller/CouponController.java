package com.inflearn.kafka.controller;

import com.inflearn.kafka.dto.CouponRequestDto;
import com.inflearn.kafka.service.ApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CouponController {
    private final ApplyService applyService;

    @PostMapping("/coupon")
    public void couponIssued(@RequestBody CouponRequestDto requestDto) {
        applyService.couponIssued(requestDto.getUserId());
    }
}
