package com.example.task.models;

import lombok.Data;
import java.io.Serializable;

@Data
public class SimModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private DeviceStatusModel deviceStatus;

    private String operatorCode;

    private String country;
}
