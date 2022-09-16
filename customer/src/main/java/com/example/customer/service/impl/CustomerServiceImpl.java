package com.example.customer.service.impl;

import com.example.customer.api.form.CustomerRegistrationRequest;
import com.example.customer.entity.Customer;
import com.example.customer.ex.AppException;
import com.example.customer.ex.ExceptionCode;
import com.example.customer.service.CustomerService;
import com.example.customer.store.repository.CustomerRepository;
import com.example.customer.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest, String clientMessageId) {
        String firstName = customerRegistrationRequest.getFirstName();
        String lastName = customerRegistrationRequest.getLastName();
        String email = customerRegistrationRequest.getEmail();
        log.info("registerCustomer - START");
        log.info("registerCustomer request: form - {}", new Object[]{Util.toJson(customerRegistrationRequest)});
        Optional<Customer> customerOptional = customerRepository.findByEmail(email);
        if(customerOptional.isPresent()) {
            log.info("registerCustomer - Duplicate email");
            throw new AppException(ExceptionCode.DUPLICATE_MOVIE, clientMessageId);
        }
        customerRepository.save(Customer.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .build());
        log.info("registerCustomer - END");
    }
}
