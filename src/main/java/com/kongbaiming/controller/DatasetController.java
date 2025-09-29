package com.kongbaiming.controller;

import com.kongbaiming.DTO.DatasetDto;
import com.kongbaiming.result.Result;
import com.kongbaiming.service.DatasetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/dataset")
@Slf4j
public class DatasetController {

    @Autowired
    private DatasetService datasetService;

    /**
     * 上传数据集
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result uploadDataset(@RequestParam("file")MultipartFile file) {
        String datasetName = file.getOriginalFilename();
        log.info("上传了数据集: {}", datasetName);
        DatasetDto datasetDto = new DatasetDto();
        datasetDto.setDatasetName(datasetName);
        datasetDto.setFile(file);

        datasetService.save(datasetDto);
        return Result.success("Dataset uploaded successfully");
    }

    /**
     * 获取数据集列表
     * @return
     */
    @GetMapping("/list")
    public Result<List<String>> listDataset() {
        log.info("获取了数据集列表");
        List<String> list = datasetService.list();
        return Result.success(list);
    }
}
