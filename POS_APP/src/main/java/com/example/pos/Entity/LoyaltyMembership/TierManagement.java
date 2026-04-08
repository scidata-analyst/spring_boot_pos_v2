package com.example.pos.entity.loyalty_membership;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "tier_management")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TierManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tierName;

    private Integer minPoints;

    private Integer maxPoints;

    private Double discountPercentage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String benefits;

    private String status;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
