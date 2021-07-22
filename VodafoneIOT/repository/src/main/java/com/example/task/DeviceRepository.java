package com.example.task;

import com.example.task.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device,Long> {

    @Query("select d from Device d where d.sim.deviceStatus.code=:deviceStatus")
    List<Device> getDevicesByDeviceStatus(@Param("deviceStatus") String deviceStatus);

}
