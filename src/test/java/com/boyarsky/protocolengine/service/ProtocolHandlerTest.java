package com.boyarsky.protocolengine.service;

import com.boyarsky.lang.runtime.IProtocol;
import com.boyarsky.lang.runtime.impl.Measurement;
import com.boyarsky.lang.runtime.impl.OutputResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProtocolHandlerTest {
    private ProtocolHandler handler;

    @Mock
    private IProtocol protocol;

    @BeforeEach
    void setUp() {
        handler = new ProtocolHandler(List.of(protocol));
    }

    @Test
    void shouldHandleMeasurementsUsingProtocolWithoutResults() {
        List<OutputResult> results = handler.handle(Collections.emptyList());

        assertThat(results).isEmpty();
    }

    @Test
    void shouldHandleMeasurementsUsingProtocolWithResults() {
        Measurement measurement = new Measurement();
        OutputResult output = createOutput();
        doReturn(List.of(output)).when(protocol).evaluate(List.of(measurement));

        List<OutputResult> results = handler.handle(List.of(measurement));

        verify(protocol).evaluate(List.of(measurement));
        assertThat(results).contains(output);
    }

    private OutputResult createOutput() {
        OutputResult res = new OutputResult();
        res.setDescription("OK");
        res.setProtocol("hypertension");
        return res;
    }
}