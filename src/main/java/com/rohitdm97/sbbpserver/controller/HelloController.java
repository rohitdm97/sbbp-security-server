package com.rohitdm97.sbbpserver.controller;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("")
public class HelloController {

    private static final Logger flow = LogManager.getLogger("flow");

    @GetMapping("/")
    public String index() {
        flow.traceEntry();
        return flow.traceExit("Greetings from Spring Boot!");
    }

    @GetMapping("/ping")
    public String ping() {
        flow.traceEntry("ping");
        return flow.traceExit("ping");
    }

    @GetMapping("/status")
    public String status() {
        flow.traceEntry("status");
        return flow.traceExit("status");
    }

    @GetMapping("/admin")
    public String admin() {
        flow.traceEntry();
        return flow.traceExit("Greetings from Spring Boot Admin!");
    }

}
