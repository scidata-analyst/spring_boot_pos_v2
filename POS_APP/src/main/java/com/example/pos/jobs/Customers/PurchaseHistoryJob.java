package com.example.pos.jobs.Customers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for PurchaseHistory.
 * <p>
 * This class is responsible for executing recurring tasks related to
 * PurchaseHistory.
 * Define job logic inside the execute() method.
 */
@Component
public class PurchaseHistoryJob {

    /**
     * Executes the scheduled job for PurchaseHistory.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for PurchaseHistory
        System.out.println("Executing job for PurchaseHistory...");
    }
}
