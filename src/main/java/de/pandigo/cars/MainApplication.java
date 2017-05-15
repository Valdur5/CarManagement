package de.pandigo.cars;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableJSONDoc
@ImportResource("classpath:spring-config.xml")
public final class MainApplication {

    private MainApplication() {
    }

    public static void main(final String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
