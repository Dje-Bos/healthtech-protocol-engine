package com.boyarsky.protocolvalidator.config;

import com.boyarsky.lang.generated.diabetes;
import com.boyarsky.lang.generated.hypertension;
import com.boyarsky.lang.runtime.IProtocol;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProtocolConfig {

    @Bean
    public IProtocol diabetesProto() {
        return new diabetes();
    }

    @Bean
    public IProtocol hypertensionProto() {
        return new hypertension();
    }
}
