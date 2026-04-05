package com.scidata_analyst.pos.dto.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String fullName;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private Double loyaltyPoints;

    private Boolean isActive;

    private Long totalOrders;

    private Double totalSpent;
}
