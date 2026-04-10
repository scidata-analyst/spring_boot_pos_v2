package com.example.pos.jobs.Products;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for StockMovement.
 * <p>
 * This class is responsible for executing recurring tasks related to
 * StockMovement.
 * Define job logic inside the execute() method.
 */
@Component
public class StockMovementJob {

    /**
     * Executes the scheduled job for StockMovement.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for StockMovement
        System.out.println("Executing job for StockMovement...");
    }
}
