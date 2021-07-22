package com.example.task.config;

import com.example.task.DeviceService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = DeviceService.class)
@Import({RepositoryConfig.class})
public class ServiceConfig {
}
