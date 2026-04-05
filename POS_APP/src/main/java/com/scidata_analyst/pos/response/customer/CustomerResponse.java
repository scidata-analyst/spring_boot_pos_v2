package com.scidata_analyst.pos.response.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private Double loyaltyPoints;
    private Boolean isActive;
    private Long totalPurchases;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
