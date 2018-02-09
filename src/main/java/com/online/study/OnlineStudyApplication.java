package com.online.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class})
@RestController
@ComponentScan("com")
@Configuration
@ImportResource(value = {"applicationContext-root.xml"})
public class OnlineStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStudyApplication.class, args);
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String home() {
//        return "hello world";
//    }
}
