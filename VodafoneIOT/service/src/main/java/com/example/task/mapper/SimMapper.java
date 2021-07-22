package com.example.task.mapper;

import com.example.task.entity.Sim;
import com.example.task.models.SimModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { DeviceStatusMapper.class})
public interface SimMapper {

    SimModel toModel(Sim sim);

    Sim toEntity(SimModel simModel);
}
