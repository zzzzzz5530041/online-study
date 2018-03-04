package com.online.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan("com.online.edu")
@Configuration
@ImportResource(value = {"applicationContext-root.xml"})
@Controller
public class OnlineEduApplication {

    public static void main(String[] args) {

        SpringApplication.run(OnlineEduApplication.class, args);
    }
    @GetMapping(value = "/")
    public String index(){
        return "redirect:/index";
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
