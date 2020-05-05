package com.boyarsky.protocolengine.config;

import com.boyarsky.lang.generated.diabetes;
import com.boyarsky.lang.generated.hypertension;
import com.boyarsky.lang.generated.sinusTachycardia;
import com.boyarsky.lang.generated.ventricularTachycardia;
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

    @Bean
    public IProtocol ventricularTachycardia() {
        return new ventricularTachycardia();
    }

    @Bean
    public IProtocol sinusTachycardia() {
        return new sinusTachycardia();
    }
}
