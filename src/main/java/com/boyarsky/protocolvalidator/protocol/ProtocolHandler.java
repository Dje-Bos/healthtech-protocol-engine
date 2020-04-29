package com.boyarsky.protocolvalidator.protocol;

import com.boyarsky.lang.runtime.IProtocol;
import com.boyarsky.lang.runtime.impl.Measurement;
import com.boyarsky.lang.runtime.impl.OutputResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProtocolHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ProtocolHandler.class);

    private List<IProtocol> protocols;

    public ProtocolHandler(List<IProtocol> protocols) {
        this.protocols = protocols;
    }

    public List<OutputResult> handle(List<Measurement> measurements) {
        LOG.info("Starting measurements {} validation", measurements);
        List<OutputResult> results = protocols.stream()
                .flatMap(proto -> proto.evaluate(measurements).stream())
                .collect(Collectors.toList());
        LOG.info("Measurements validation ended with results {}", results);
        return results;
    }
}
