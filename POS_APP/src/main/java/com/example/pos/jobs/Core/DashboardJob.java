package com.example.pos.jobs.Core;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Dashboard.
 * <p>
 * This class is responsible for executing recurring tasks related to Dashboard.
 * Define job logic inside the execute() method.
 */
@Component
public class DashboardJob {

    /**
     * Executes the scheduled job for Dashboard.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for Dashboard
        System.out.println("Executing job for Dashboard...");
    }
}
