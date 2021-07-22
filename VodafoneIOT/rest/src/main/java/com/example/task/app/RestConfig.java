package com.example.task.app;

import com.example.task.rest.DeviceResource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = DeviceResource.class)
public class RestConfig {
}
