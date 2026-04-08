package com.example.pos.Request.Suppliers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSupplierDirectoryRequest {
    private String name;
    private String contactPerson;
    private String email;
    private String phone;
    private String address;
    private String status;
}
