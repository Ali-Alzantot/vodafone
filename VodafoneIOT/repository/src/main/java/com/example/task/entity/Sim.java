package com.example.task.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SIM")
@Data
@EqualsAndHashCode(of = "id" )
public class Sim implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DEVICE_STATUS_ID")
    private DeviceStatus deviceStatus;

    @Column(name = "OPERATOR_CODE")
    private String operatorCode;

    @Column(name = "COUNTRY")
    private String country;
}
