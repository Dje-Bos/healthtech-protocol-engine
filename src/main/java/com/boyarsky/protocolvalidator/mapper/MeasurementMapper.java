package com.boyarsky.protocolvalidator.mapper;

import com.boyarsky.lang.runtime.impl.Measurement;
import com.boyarsky.protocolvalidator.dto.MeasurementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MeasurementMapper {
    MeasurementMapper MEASUREMENT_MAPPER = Mappers.getMapper(MeasurementMapper.class);

    @Mappings({
            @Mapping(target = "unit"),
            @Mapping(target = "type"),
            @Mapping(target = "value"),
            @Mapping(target = "created")
    })
    Measurement toProtocolMeasurement(MeasurementDto dto);
}
