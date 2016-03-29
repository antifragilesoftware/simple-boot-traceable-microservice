package com.russmiles.antifragilesoftware.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SimpleBootTraceableMicroserviceApplication {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping("/")
    public String home() {
        log.info("Root URL invoked");

        return this.toString() + " instance saying: Hello Microservice World\n";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleBootTraceableMicroserviceApplication.class, args);
    }
}
