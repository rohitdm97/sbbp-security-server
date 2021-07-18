package com.rohitdm97.sbbpserver.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// need to set as to override value from super
// put this at the end,, so not to override WebSecurityConfig
@Order(Integer.MAX_VALUE - 1000)
public class SwaggerBypassConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/v2/api-docs")
                .antMatchers("/configuration/ui")
                .antMatchers("/configuration/security")
                .antMatchers("/webjars/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/swagger-ui.html")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // overridden to remove default config
    }

}
