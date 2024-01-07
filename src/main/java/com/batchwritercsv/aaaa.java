package com.batchwritercsv;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class aaaa {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        String now = LocalDateTime.now().format(formatter);
        System.out.println(now);
    }
}
