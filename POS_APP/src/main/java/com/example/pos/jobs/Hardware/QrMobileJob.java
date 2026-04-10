package com.example.pos.jobs.Hardware;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for QrMobile.
 * <p>
 * This class is responsible for executing recurring tasks related to QrMobile.
 * Define job logic inside the execute() method.
 */
@Component
public class QrMobileJob {

    /**
     * Executes the scheduled job for QrMobile.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for QrMobile
        System.out.println("Executing job for QrMobile...");
    }
}
