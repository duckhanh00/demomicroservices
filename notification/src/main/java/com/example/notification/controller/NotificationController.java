package com.example.notification.controller;

import com.example.clients.notification.NotificationRequest;
import com.example.notification.api.response.ApiResponse;
import com.example.notification.api.response.SuccessResponse;
import com.example.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse registerCustomer(@RequestHeader(name = "clientMessageId") String clientMessageId,
                                        @RequestBody @Valid NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
        return new SuccessResponse(clientMessageId);
    }
}
