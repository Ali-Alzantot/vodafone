package com.example.task;

import com.example.task.models.DeviceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeviceService {
    List<DeviceModel> getAllDevicesWaitingForActivation();
    List<DeviceModel> getAllDevicesAvailableForSale();
    DeviceModel updateDeviceStatus(Long deviceId, Long statusId) throws Exception;
    DeviceModel removeDevice(Long deviceId) throws Exception;
}
