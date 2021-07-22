package com.example.task.config;

import com.example.task.DeviceRepository;
import com.example.task.entity.Device;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = DeviceRepository.class)
@EntityScan(basePackageClasses = {Device.class})
public class RepositoryConfig {
}
