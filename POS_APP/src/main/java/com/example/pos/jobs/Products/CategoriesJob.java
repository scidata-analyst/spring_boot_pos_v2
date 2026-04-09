package com.example.pos.jobs.Products;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled job class for Categories.
 * <p>
 * This class is responsible for executing recurring tasks related to Categories.
 * Define job logic inside the execute() method.
 */
@Component
public class CategoriesJob {

    /**
     * Executes the scheduled job for Categories.
     * Runs every hour (customize cron expression as needed).
     */
    @Scheduled(cron = ""0 0 * * * ?"")
    public void execute() {
        // TODO: Implement the job logic for Categories
        System.out.println(""Executing job for Categories..."");
    }
}
