package com.example.pos.jobs.Products;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * =====================================================
 * Scheduled Job: Categories
 * =====================================================
 *
 * This job runs background tasks for Categories.
 *
 * Notes:
 * - No service dependency (safe compile)
 * - Add service later if needed
 * - Requires @EnableScheduling in main class
 */
@Component
public class CategoriesJob {

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

        System.out.println("Running Categories job...");

        // Add business logic here
        // Example:
        // - cleanup expired records
        // - update status
        // - sync data

    }
}
