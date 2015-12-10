package com.ibs.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class TimesheetApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TimesheetApp.class, args);
    }
}