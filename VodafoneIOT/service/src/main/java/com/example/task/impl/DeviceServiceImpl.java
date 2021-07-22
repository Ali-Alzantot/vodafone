package com.example.task.impl;

import com.example.task.DeviceRepository;
import com.example.task.DeviceService;
import com.example.task.DeviceStatusRepository;
import com.example.task.entity.Device;
import com.example.task.entity.DeviceStatus;
import com.example.task.mapper.DeviceMapper;
import com.example.task.models.ApiException;
import com.example.task.models.DeviceModel;
import com.example.task.models.DeviceStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    DeviceMapper deviceMapper;

    @Autowired
    DeviceStatusRepository deviceStatusRepository;

    @Override
    public List<DeviceModel> getAllDevicesWaitingForActivation() {
        List<Device> devices = deviceRepository.getDevicesByDeviceStatus(DeviceStatusEnum.WAITING_FOR_ACTIVATION.name());

        if(devices != null && devices.size() > 0) {
            List<DeviceModel> devicesModels = devices
                    .stream()
                    .map(deviceMapper::toModel)
                    .collect(Collectors.toList());
            return devicesModels;
        }

        return new ArrayList<DeviceModel>();
    }

    @Override
    public List<DeviceModel> getAllDevicesAvailableForSale() {
        List<Device> devices = deviceRepository.getDevicesByDeviceStatus(DeviceStatusEnum.READY.name());

        if(devices != null && devices.size() > 0) {
            List<DeviceModel> devicesModels = devices
                    .stream()
                    .filter(device -> device.getTemperature()>= -25 && device.getTemperature()<= 85)
                    .map(deviceMapper::toModel)
                    .collect(Collectors.toList());
            return devicesModels;
        }

        return new ArrayList<DeviceModel>();
    }

    @Override
    public DeviceModel updateDeviceStatus(Long deviceId, Long statusId) throws Exception {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new ApiException("400"," bad request paramters device with id "+deviceId+" not found"));
        DeviceStatus deviceStatus = deviceStatusRepository.findById(statusId).orElseThrow(() -> new ApiException("400"," bad request paramters status with id "+statusId+" not found"));

        if(device == null || device.getSim() == null || deviceStatus == null) {
            throw new ApiException("400"," bad request paramters");
        }

        device.getSim().setDeviceStatus(deviceStatus);
        return deviceMapper.toModel(deviceRepository.save(device));
    }

    @Override
    public DeviceModel removeDevice(Long deviceId) throws Exception{
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new ApiException("400"," bad request paramters device with id "+deviceId+" not found"));
        DeviceStatus deviceBlockedStatus = deviceStatusRepository.findByCode(DeviceStatusEnum.BLOCKED.name()).orElseThrow(() -> new ApiException("500"," blocked status not found in DB"));

        if(device == null || device.getSim() == null || deviceBlockedStatus == null) {
            throw new ApiException("400"," bad request paramters");
        }

        device.getSim().setDeviceStatus(deviceBlockedStatus);
        return deviceMapper.toModel(deviceRepository.save(device));
    }
}
