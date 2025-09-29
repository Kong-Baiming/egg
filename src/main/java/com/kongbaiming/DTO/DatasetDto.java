package com.kongbaiming.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DatasetDto {
    private String datasetName;
    private MultipartFile file;
}
