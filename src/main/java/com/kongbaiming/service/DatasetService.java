package com.kongbaiming.service;

import com.kongbaiming.DTO.DatasetDto;
import com.kongbaiming.properties.DatasetProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 获取数据集列表
     * @return
     */
    public List<String> list() {
        List<String> datasetNames = new ArrayList<>();

        String path = datasetProperties.getPath();
        File dir = new File(path);

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    datasetNames.add(file.getName());
                }
            }
        }

        return datasetNames;
    }

    /**
     * 删除数据集
     * @param datasetName
     */
    public void delete(String datasetName) {
        try {
            String filePath = datasetProperties.getPath() + datasetName;
            File file = new File(filePath);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (deleted) {
                    log.info("数据集删除成功: {}", filePath);
                } else {
                    log.warn("数据集删除失败: {}", filePath);

                }
            } else {
                log.warn("数据集文件不存在: {}", filePath);
            }
        } catch (Exception e) {
            log.error("删除数据集时发生异常: {}", datasetName, e);
            e.printStackTrace();
        }
    }

}
