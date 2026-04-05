package com.scidata_analyst.pos.request.supplier;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSupplierRequest {

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
}
