package com.example.pos.jobs.Payment;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for CashRegister.
 * <p>
 * This class is responsible for executing recurring tasks related to CashRegister.
 * Define job logic inside the execute() method.
 */
@Component
public class CashRegisterJob {

    /**
     * Executes the scheduled job for CashRegister.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = ""0 0 * * * ?"")
    public void execute() {
        // TODO: Implement the job logic for CashRegister
        System.out.println(""Executing job for CashRegister..."");
    }
}
