package com.kongbaiming.service;

import com.kongbaiming.DTO.DatasetDto;
import com.kongbaiming.properties.DatasetProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
@Slf4j
public class DatasetService {

    @Autowired
    private DatasetProperties datasetProperties;

    /**
     * 保存数据集
     * @param datasetDto
     */
    public void save(DatasetDto datasetDto) {
        MultipartFile file = datasetDto.getFile();
        if (!file.isEmpty()){
            try {
                // 数据集存放路径
                String filePath = datasetProperties.getPath() + file.getOriginalFilename();
                File dest = new File(filePath);
                file.transferTo(dest); // 保存文件
                log.info("数据集保存成功, 路径: {}", filePath);
            } catch (Exception e) {
                e.printStackTrace(); // 实际应用中建议使用日志框架记录异常
            }
        }
    }
}
