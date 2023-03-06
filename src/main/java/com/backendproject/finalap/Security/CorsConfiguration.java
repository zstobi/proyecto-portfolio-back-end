package com.backendproject.finalap.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/login")
//                        .allowedOrigins("http://localhost:4200")
                        .allowedOrigins("https://apfinal-frontend.web.app")
                        .allowedMethods("*")
                        .exposedHeaders("*");

// podemos especificar una ruta generica para varios endpoints, ejemplo: ("/ruta/**")
                
                registry.addMapping("/abtm/**")
//                        .allowedOrigins("http://localhost:4200")
                        .allowedOrigins("https://apfinal-frontend.web.app")
                        .allowedMethods("*");
                
                registry.addMapping("/prjs/**")
//                        .allowedOrigins("http://localhost:4200")
                        .allowedOrigins("https://apfinal-frontend.web.app")
                        .allowedMethods("*");
                
                registry.addMapping("/ed/**")
//                        .allowedOrigins("http://localhost:4200")
                        .allowedOrigins("https://apfinal-frontend.web.app")
                        .allowedMethods("*");
                
                registry.addMapping("/techs/**")
//                        .allowedOrigins("http://localhost:4200")
                        .allowedOrigins("https://apfinal-frontend.web.app")
                        .allowedMethods("*");
                
                registry.addMapping("/ss/**")
//                        .allowedOrigins("http://localhost:4200")
                        .allowedOrigins("https://apfinal-frontend.web.app")
                        .allowedMethods("*");
            }
        };

    };
}

