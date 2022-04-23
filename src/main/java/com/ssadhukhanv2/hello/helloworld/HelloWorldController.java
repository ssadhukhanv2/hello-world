package com.ssadhukhanv2.hello.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("hello")
@Slf4j
public class HelloWorldController {

    @Value("${hlwd.greeting.message:Hello}")
    private String greetings;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String release;

    @GetMapping("/")
    public String getIndex() {
        return "Healthy";
    }

    @GetMapping("/hello")
    public String getHelloMessage() {
        return String.format("%s from %s:%s", greetings, appName, release);
    }


    @GetMapping("/hello/")
    public String getHelloMessageWithSlash() {
        return String.format("Slashes URL......\n %s from %s:%s", greetings, appName, release);
    }
}
