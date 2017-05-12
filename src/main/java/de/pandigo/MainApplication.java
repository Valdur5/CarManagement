//@formatter:off
/**
 * $$Id$$
 * . * .
 * * RRRR  *    Copyright (c) 2016 EUIPO: European Union Intellectual
 * .   RR  R   .  Property Office (trade marks and designs)
 * *   RRR     *
 * .  RR RR  .   ALL RIGHTS RESERVED
 * * . _ . *
 */
//@formatter:on
package de.pandigo;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
