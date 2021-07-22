package com.example.task.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DEVICE")
@Data
@EqualsAndHashCode(of = "id" )
public class Device implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name = "temperature")
    private Long temperature;

    @OneToOne
    @JoinColumn(name = "SIM_ID")
    private Sim sim;
}
