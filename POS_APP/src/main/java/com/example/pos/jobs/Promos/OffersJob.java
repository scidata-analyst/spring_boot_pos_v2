package com.example.pos.jobs.Promos;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Offers.
 * <p>
 * This class is responsible for executing recurring tasks related to Offers.
 * Define job logic inside the execute() method.
 */
@Component
public class OffersJob {

    /**
     * Executes the scheduled job for Offers.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for Offers
        System.out.println("Executing job for Offers...");
    }
}
