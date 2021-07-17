package com.rohitdm97.sbbpserver.config.web;

import javax.annotation.PostConstruct;
import javax.servlet.Filter;

import com.rohitdm97.sbbpserver.security.AuthenticationFilterImpl;
import com.rohitdm97.sbbpserver.security.AuthenticationProviderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
// atleast one of prePostEnabled, securedEnabled, jsr250Enabled must be true
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // does actual authentication
    private final AuthenticationProvider authenticationProvider;

    // filter to intercept request before handled controller
    private Filter authenticationFilter;

    public WebSecurityConfig(AuthenticationProviderImpl authenticationProviderImpl) {
        // config here
        this.authenticationProvider = authenticationProviderImpl;
    }

    /**
     * configure(WebSecurity) is used for configuration settings that impact global security (ignore resources, set
     * debug mode, reject requests by implementing a custom firewall definition). For example, the following method
     * would cause any request that starts with /resources/ to be ignored for authentication purposes.
     *
     * @see [https://stackoverflow.com/questions/56388865/spring-security-configuration-httpsecurity-vs-websecurity]
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/ping")
                .antMatchers("/status")
                .antMatchers("/resources/**")
                .antMatchers("/public/**");
    }

    /**
     * configure(HttpSecurity) allows configuration of web-based security at a resource level, based on a selection
     * match - e.g. The example below restricts the URLs that start with /admin/ to users that have ADMIN role, and
     * declares that any other URLs need to be successfully authenticated.
     *
     * @see [https://stackoverflow.com/questions/56388865/spring-security-configuration-httpsecurity-vs-websecurity]
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) {
        builder.authenticationProvider(authenticationProvider);
    }

    @Bean
    public AuthenticationEntryPoint forbiddenEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.FORBIDDEN);
    }

    @PostConstruct
    public void init() throws Exception {
        // init filter impl
        this.authenticationFilter = new AuthenticationFilterImpl(authenticationManager());
    }

}
