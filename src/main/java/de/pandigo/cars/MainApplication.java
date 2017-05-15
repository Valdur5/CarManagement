package de.pandigo.cars;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableJSONDoc
@ImportResource("classpath:spring-config.xml")
public class MainApplication {


    public static void main(final String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
