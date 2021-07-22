package com.example.task;

import com.example.task.entity.DeviceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceStatusRepository extends JpaRepository<DeviceStatus,Long> {
    Optional<DeviceStatus> findByCode(String code);
}
