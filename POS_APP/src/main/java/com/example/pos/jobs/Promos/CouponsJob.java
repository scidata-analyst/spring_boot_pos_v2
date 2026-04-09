package com.example.pos.jobs.Promos;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Coupons.
 * <p>
 * This class is responsible for executing recurring tasks related to Coupons.
 * Define job logic inside the execute() method.
 */
@Component
public class CouponsJob {

    /**
     * Executes the scheduled job for Coupons.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = ""0 0 * * * ?"")
    public void execute() {
        // TODO: Implement the job logic for Coupons
        System.out.println(""Executing job for Coupons..."");
    }
}
