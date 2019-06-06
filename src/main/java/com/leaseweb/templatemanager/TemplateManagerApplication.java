package com.leaseweb.templatemanager;

import java.util.Arrays;
import java.util.Collections;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class TemplateManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateManagerApplication.class, args);
    }

}
