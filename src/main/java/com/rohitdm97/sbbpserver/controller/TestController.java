package com.rohitdm97.sbbpserver.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @RequestMapping("/ping")
    public String pong() {
        return "PONG\f\n";
    }

}
