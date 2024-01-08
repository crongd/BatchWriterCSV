package com.batchwritercsv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BatchWriterCsvApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchWriterCsvApplication.class, args);
    }

}
