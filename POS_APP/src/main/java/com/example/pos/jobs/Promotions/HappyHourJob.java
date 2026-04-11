package com.example.pos.jobs.Promotions;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * =====================================================
 * Scheduled Job: HappyHour
 * =====================================================
 *
 * This job runs background tasks for HappyHour.
 *
 * Notes:
 * - No service dependency (safe compile)
 * - Add service later if needed
 * - Requires @EnableScheduling in main class
 */
@Component
public class HappyHourJob {

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

        System.out.println("Running HappyHour job...");

        // Add business logic here
        // Example:
        // - cleanup expired records
        // - update status
        // - sync data

    }
}
