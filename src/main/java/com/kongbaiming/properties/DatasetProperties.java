package com.kongbaiming.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dataset.upload")
@Data
public class DatasetProperties {
    private String path;
}
