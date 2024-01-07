package com.batchwritercsv.mappers;

import com.batchwritercsv.dto.CsvDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<CsvDTO> all_select();

    void all_delete();
}
