package com.example.task.mapper;

import com.example.task.entity.Device;
import com.example.task.models.DeviceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { SimMapper.class})
public interface DeviceMapper {

    DeviceModel toModel(Device device);

    Device toEntity(DeviceModel deviceModel);

}
