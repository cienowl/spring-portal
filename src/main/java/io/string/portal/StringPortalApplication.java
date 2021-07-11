package io.string.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class StringPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringPortalApplication.class, args);
    }

}
