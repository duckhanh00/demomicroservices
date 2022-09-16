package com.example.customer.api.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
}
