package com.rohitdm97.sbbpserver.config.shiro;

import lombok.RequiredArgsConstructor;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.config.ShiroAnnotationProcessorConfiguration;
import org.apache.shiro.spring.config.ShiroBeanConfiguration;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({
        ShiroBeanConfiguration.class,
        ShiroConfiguration.class,
        ShiroAnnotationProcessorConfiguration.class
})
@Configuration

@RequiredArgsConstructor
public class ShiroRealmConfig {

    private final SecurityManager securityManager;

}
