package com.boyarsky.protocolengine.mapper;

import com.boyarsky.lang.runtime.impl.Measurement;
import com.boyarsky.protocolengine.dto.MeasurementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeasurementMapper {
    MeasurementMapper MEASUREMENT_MAPPER = Mappers.getMapper(MeasurementMapper.class);

    @Mappings({
            @Mapping(target = "unit", ignore = true),
            @Mapping(target = "type", expression = "java(com.boyarsky.lang.runtime.impl.MType.valueOf(dto.getType().toUpperCase()))"),
            @Mapping(target = "value"),
            @Mapping(target = "created"),
            @Mapping(target = "uid", ignore = true)
    })
    Measurement toProtocolMeasurement(MeasurementDto dto);
}
