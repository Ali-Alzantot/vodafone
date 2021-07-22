package com.example.task.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long temperature;
    private SimModel sim;
}
