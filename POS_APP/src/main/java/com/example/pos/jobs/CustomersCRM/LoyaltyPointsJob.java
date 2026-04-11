package com.example.pos.jobs.CustomersCRM;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * =====================================================
 * Scheduled Job: LoyaltyPoints
 * =====================================================
 *
 * This job runs background tasks for LoyaltyPoints.
 *
 * Notes:
 * - No service dependency (safe compile)
 * - Add service later if needed
 * - Requires @EnableScheduling in main class
 */
@Component
public class LoyaltyPointsJob {

    /**
     * =====================================================
     * Scheduled Task
     * =====================================================
     *
     * Runs every 10 minutes.
     */
    @Scheduled(cron = "0 */10 * * * *")
    public void handle() {

        // =====================================================
        // Job Execution
        // =====================================================

        System.out.println("Running LoyaltyPoints job...");

        // Add business logic here
        // Example:
        // - cleanup expired records
        // - update status
        // - sync data

    }
}
