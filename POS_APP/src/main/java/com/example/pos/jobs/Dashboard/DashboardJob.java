package com.example.pos.jobs.Dashboard;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * =====================================================
 * Scheduled Job: Dashboard
 * =====================================================
 *
 * This job runs background tasks for Dashboard.
 *
 * Notes:
 * - No service dependency (safe compile)
 * - Add service later if needed
 * - Requires @EnableScheduling in main class
 */
@Component
public class DashboardJob {

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

        System.out.println("Running Dashboard job...");

        // Add business logic here
        // Example:
        // - cleanup expired records
        // - update status
        // - sync data

    }
}
