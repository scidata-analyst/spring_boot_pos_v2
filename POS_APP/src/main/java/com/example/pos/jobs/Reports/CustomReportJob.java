package com.example.pos.jobs.Reports;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for CustomReport.
 * <p>
 * This class is responsible for executing recurring tasks related to
 * CustomReport.
 * Define job logic inside the execute() method.
 */
@Component
public class CustomReportJob {

    /**
     * Executes the scheduled job for CustomReport.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for CustomReport
        System.out.println("Executing job for CustomReport...");
    }
}
