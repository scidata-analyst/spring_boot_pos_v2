package com.example.pos.jobs.Suppliers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for SupplierPayments.
 * <p>
 * This class is responsible for executing recurring tasks related to
 * SupplierPayments.
 * Define job logic inside the execute() method.
 */
@Component
public class SupplierPaymentsJob {

    /**
     * Executes the scheduled job for SupplierPayments.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for SupplierPayments
        System.out.println("Executing job for SupplierPayments...");
    }
}
