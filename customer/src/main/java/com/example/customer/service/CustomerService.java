package com.example.customer.service;

import com.example.customer.api.form.CustomerRegistrationRequest;

public interface CustomerService {
    void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest, String ClientMessageId);
}
