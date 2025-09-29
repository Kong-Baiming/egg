package com.kongbaiming.controller;

import com.kongbaiming.DTO.DatasetDto;
import com.kongbaiming.result.Result;
import com.kongbaiming.service.DatasetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/dataset")
@Slf4j
public class DatasetController {

    @Autowired
    private DatasetService datasetService;

    @PostMapping("/upload")
    public Result uploadDataset(@RequestParam("datasetName") String datasetName,
                                @RequestParam("file")MultipartFile file) {
        log.info("上传了数据集: {}", datasetName);

        DatasetDto datasetDto = new DatasetDto();
        datasetDto.setDatasetName(datasetName);
        datasetDto.setFile(file);

        datasetService.save(datasetDto);
        return Result.success("Dataset uploaded successfully");
    }
}
