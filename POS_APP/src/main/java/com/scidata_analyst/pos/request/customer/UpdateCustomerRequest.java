package com.scidata_analyst.pos.request.customer;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {

    private String firstName;

    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private Boolean isActive;
}
