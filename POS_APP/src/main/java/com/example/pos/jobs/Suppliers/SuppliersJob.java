package com.example.pos.jobs.Suppliers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Suppliers.
 * <p>
 * This class is responsible for executing recurring tasks related to Suppliers.
 * Define job logic inside the execute() method.
 */
@Component
public class SuppliersJob {

    /**
     * Executes the scheduled job for Suppliers.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = ""0 0 * * * ?"")
    public void execute() {
        // TODO: Implement the job logic for Suppliers
        System.out.println(""Executing job for Suppliers..."");
    }
}
