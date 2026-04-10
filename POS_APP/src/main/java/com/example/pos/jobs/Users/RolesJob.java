package com.example.pos.jobs.Users;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Roles.
 * <p>
 * This class is responsible for executing recurring tasks related to Roles.
 * Define job logic inside the execute() method.
 */
@Component
public class RolesJob {

    /**
     * Executes the scheduled job for Roles.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void execute() {
        // TODO: Implement the job logic for Roles
        System.out.println("Executing job for Roles...");
    }
}
