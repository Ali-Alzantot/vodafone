package com.example.task.mapper;
import com.example.task.entity.DeviceStatus;
import com.example.task.models.DeviceStatusModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeviceStatusMapper {

    DeviceStatusModel toModel(DeviceStatus deviceStatus);

    DeviceStatus toEntity(DeviceStatusModel deviceStatusModel);
}
