package com.example.pos.jobs.Users;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Cashiers.
 * <p>
 * This class is responsible for executing recurring tasks related to Cashiers.
 * Define job logic inside the execute() method.
 */
@Component
public class CashiersJob {

    /**
     * Executes the scheduled job for Cashiers.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = ""0 0 * * * ?"")
    public void execute() {
        // TODO: Implement the job logic for Cashiers
        System.out.println(""Executing job for Cashiers..."");
    }
}
