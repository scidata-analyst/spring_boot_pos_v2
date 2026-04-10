package com.example.pos.jobs.Hardware;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Devices.
 * <p>
 * This class is responsible for executing recurring tasks related to Devices.
 * Define job logic inside the execute() method.
 */
@Component
public class DevicesJob {

    /**
     * Executes the scheduled job for Devices.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for Devices
        System.out.println("Executing job for Devices...");
    }
}
