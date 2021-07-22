package com.example.task.config;

import com.example.task.models.DeviceModel;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DeviceModel.class)
public class ModelsConfig {
}
