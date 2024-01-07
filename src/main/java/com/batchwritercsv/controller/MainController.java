package com.batchwritercsv.controller;


import com.batchwritercsv.dto.CsvDTO;
import com.batchwritercsv.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    BatchService batchService;

    @GetMapping("/select")
    public List<CsvDTO> test() {
        return batchService.all_select();
    }

    @GetMapping("/writer")
    public void csv_write() throws Exception {
        batchService.csv_writer();
    }
}

