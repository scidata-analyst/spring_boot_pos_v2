package com.scidata_analyst.pos.dto.supplier;

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
public class SupplierDTO {

    private Long id;

    @NotBlank(message = "Supplier name is required")
    private String name;

    private String contactPerson;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private String address;

    private String city;

    private String state;

    private String zipCode;

    private String taxNumber;

    private Boolean isActive;

    private Long productCount;
}
