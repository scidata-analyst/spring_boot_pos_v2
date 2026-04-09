package com.example.pos.jobs.Hardware;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for CashDrawer.
 * <p>
 * This class is responsible for executing recurring tasks related to CashDrawer.
 * Define job logic inside the execute() method.
 */
@Component
public class CashDrawerJob {

    /**
     * Executes the scheduled job for CashDrawer.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = ""0 0 * * * ?"")
    public void execute() {
        // TODO: Implement the job logic for CashDrawer
        System.out.println(""Executing job for CashDrawer..."");
    }
}
