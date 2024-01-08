package com.batchwritercsv;

import com.batchwritercsv.service.BatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BatchWriterCsvApplicationTests {
    @Autowired
    private BatchService batchService;

    @Test
    void contextLoads() throws Exception {
        batchService.csv_writer();
    }

}
