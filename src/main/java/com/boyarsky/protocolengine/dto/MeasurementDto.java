package com.boyarsky.protocolengine.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeasurementDto {
    private String type;
    private LocalDateTime created;
    private String value;
    private String unit;


}
