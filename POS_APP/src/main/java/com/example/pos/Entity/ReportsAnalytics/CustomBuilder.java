package com.example.pos.entity.reports_analytics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "custom_builder")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomBuilder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reportName;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String queryConfig;

    private String chartType;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String filters;

    private Long createdBy;

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
