package com.batchwritercsv.service;

import com.batchwritercsv.dto.CsvDTO;
import com.batchwritercsv.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BatchService {
    @Autowired
    UserMapper userMapper;

    public List<CsvDTO> all_select() {
        return userMapper.all_select();
    }


    @Scheduled(cron = "0 40 5 * * *")
    public void csv_writer() throws Exception {
        StringBuilder csv = new StringBuilder();
        csv.append("지역명, 총조회수 \n");

        List<CsvDTO> select_data = userMapper.all_select();
        for (CsvDTO csvDTO : select_data) {
            csv.append(csvDTO.getArea())
                    .append(",")
                    .append(csvDTO.getCount())
                    .append("\n");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
        String date = LocalDateTime.now().format(formatter);

        String filePath = "src/main/resources/" + date + "_통계.csv";
//        URI filePathUri = new URI(filePath);
        Files.writeString(Path.of(filePath), csv.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        userMapper.all_delete();

    }

}
