package com.example.fraud.controller;

import com.example.fraud.api.response.ApiResponse;
import com.example.fraud.api.response.SuccessResponse;
import com.example.fraud.entity.FraudCheckHistory;
import com.example.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {
    @Autowired
    FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public ApiResponse FraudCheckResponse(@RequestHeader(name = "clientMessageId") String clientMessageId,
                                  @PathVariable("customerId") Integer customerId,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "10") Integer size) {
        boolean isFraudulentCheck = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}", customerId);
        return new SuccessResponse(clientMessageId, isFraudulentCheck);
    }
}
