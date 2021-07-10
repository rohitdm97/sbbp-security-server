package com.rohitdm97.sbbpserver;

import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(HelloController.class);

    @RequestMapping("/")
    public String index() {
        log.entry();
        return log.exit("Greetings from Spring Boot!");
    }

}
