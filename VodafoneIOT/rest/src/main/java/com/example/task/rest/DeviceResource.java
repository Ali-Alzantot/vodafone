package com.example.task.rest;

import com.example.task.DeviceService;
import com.example.task.models.DeviceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceResource {

    @Autowired
    DeviceService deviceService;

    @GetMapping("ready")
    public List<DeviceModel> getAllDevicesAvailableForSale() {
        return deviceService.getAllDevicesAvailableForSale();
    }

    @GetMapping("waiting")
    public List<DeviceModel> getAllDevicesWaitingForActivation() {
        return deviceService.getAllDevicesWaitingForActivation();
    }

    @PutMapping("{deviceId}/status/{statusId}")
    public DeviceModel updateDeviceStatus(@PathVariable Long deviceId, @PathVariable Long statusId) throws Exception {
        return deviceService.updateDeviceStatus(deviceId, statusId);
    }

    @DeleteMapping("{deviceId}")
    public DeviceModel updateDeviceStatus(@PathVariable Long deviceId) throws Exception{
        return deviceService.removeDevice(deviceId);
    }

}
