package com.example.pos.DTO.CustomersCRM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MembershipsVIPDTO {
    private Long id;
    private Long customerId;
    private String membershipType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String benefits;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
