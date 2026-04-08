package com.example.pos.Request.CustomersCRM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMembershipsVIPRequest {
    private Long customerId;
    private String membershipType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String benefits;
    private String status;
}
