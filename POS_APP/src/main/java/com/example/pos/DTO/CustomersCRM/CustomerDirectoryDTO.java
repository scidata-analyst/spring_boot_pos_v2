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
public class CustomerDirectoryDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String loyaltyTier;
    private Float points;
    private Double totalSpent;
    private String visits;
    private String lastVisitDate;
    private String status;
    private LocalDate dateOfBirth;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
