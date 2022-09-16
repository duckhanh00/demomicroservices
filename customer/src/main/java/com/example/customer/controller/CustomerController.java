package com.example.customer.controller;

import com.example.customer.api.form.CustomerRegistrationRequest;
import com.example.customer.api.response.ApiResponse;
import com.example.customer.api.response.SuccessResponse;
import com.example.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse registerCustomer(@RequestHeader(name = "clientMessageId") String clientMessageId,
                                        @RequestBody @Valid CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.registerCustomer(customerRegistrationRequest, clientMessageId);
        return new SuccessResponse(clientMessageId);
    }
}