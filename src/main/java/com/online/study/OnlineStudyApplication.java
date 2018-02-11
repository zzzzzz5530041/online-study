package com.online.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
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

//    @Bean
//    public ViewResolver viewResolver() {
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setTemplateMode("XHTML");
//        templateResolver.setPrefix("templates/");
//        templateResolver.setSuffix(".html");
//
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver);
//
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(engine);
//        return viewResolver;
//    }
}
