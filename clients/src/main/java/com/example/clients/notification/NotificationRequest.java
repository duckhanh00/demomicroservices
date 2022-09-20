package com.example.clients.notification;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationRequest {
        Integer toCustomerId;
        String toCustomerName;
        String message;
}
