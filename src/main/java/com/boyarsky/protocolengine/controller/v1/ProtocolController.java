package com.boyarsky.protocolengine.controller.v1;

import com.boyarsky.lang.runtime.impl.Measurement;
import com.boyarsky.lang.runtime.impl.OutputResult;
import com.boyarsky.protocolengine.dto.MeasurementDto;
import com.boyarsky.protocolengine.service.ProtocolHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.boyarsky.protocolengine.controller.ApiConstants.API_VERSION_1;
import static com.boyarsky.protocolengine.mapper.MeasurementMapper.MEASUREMENT_MAPPER;

@RestController
@RequestMapping(API_VERSION_1 + "/protocols")
public class ProtocolController {
    private static final Logger LOG = LoggerFactory.getLogger(ProtocolController.class);

    private final ProtocolHandler handler;

    public ProtocolController(ProtocolHandler handler) {
        this.handler = handler;
    }

    @PostMapping
    public List<OutputResult> handle(@RequestBody List<MeasurementDto> measurementDtos) {
        List<Measurement> measurements = measurementDtos.stream()
                .map(MEASUREMENT_MAPPER::toProtocolMeasurement)
                .collect(Collectors.toList());
        return handler.handle(measurements);
    }
}
