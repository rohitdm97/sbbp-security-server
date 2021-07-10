package com.rohitdm97.sbbpserver;

import java.util.Arrays;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@Log4j2
@SpringBootApplication
public class SbbpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbbpServerApplication.class, args);
        System.out.println("//");
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            if (log.isDebugEnabled()) {
                log.debug("Let's inspect the beans provided by Spring Boot:");
                String[] beanNames = ctx.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    log.debug(beanName);
                }
            }
        };
    }


}
