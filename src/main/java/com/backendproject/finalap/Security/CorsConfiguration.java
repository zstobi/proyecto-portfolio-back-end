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
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*")
                        .exposedHeaders("*");

// podemos especificar una ruta generica para varios endpoints, ejemplo: ("/ruta/**")
                
                registry.addMapping("/abtm/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
                
                registry.addMapping("/prjs/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
                
                registry.addMapping("/ed/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
                
                registry.addMapping("/techs/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
                
                registry.addMapping("/ss/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
                
//                registry.addMapping("/ed/update/{id}")
//                        .allowedOrigins("http://localhost:4200")
//                        .allowedMethods("*")
//                        .exposedHeaders("*");
//                
//                registry.addMapping("/ed/list")
//                        .allowedOrigins("http://localhost:4200")
//                        .allowedMethods("*")
//                        .exposedHeaders("*");
//                
//                registry.addMapping("/ed/add")
//                        .allowedOrigins("http://localhost:4200")
//                        .allowedMethods("*")
//                        .exposedHeaders("*");
//                
//                registry.addMapping("/ed/delete/{id}")
//                        .allowedOrigins("http://localhost:4200")
//                        .allowedMethods("*")
//                        .exposedHeaders("*");
            }
        };

    };
}

