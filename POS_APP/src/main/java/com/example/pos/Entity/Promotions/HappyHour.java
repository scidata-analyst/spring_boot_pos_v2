package com.example.pos.entity.promotions;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "happy_hour")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HappyHour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalTime startTime;

    private LocalTime endTime;

    private String daysOfWeek;

    private Double discountPercentage;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String applicableProducts;

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
