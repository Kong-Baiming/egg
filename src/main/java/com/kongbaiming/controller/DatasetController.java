package com.kongbaiming.controller;

import com.kongbaiming.DTO.DatasetDto;
import com.kongbaiming.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataset")
@Slf4j
public class DatasetController {

    @PostMapping("upload")
    public Result uploadDataset(DatasetDto datasetDto)
    {
        log.info("上传了数据集: {}", datasetDto.getDatasetName());
        return Result.success();
    }
}
