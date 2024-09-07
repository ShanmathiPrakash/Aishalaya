package com.example.RealEstateCRM.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080","http://localhost","http://192.168.0.139","http://127.0.0.1:5501","http://127.0.0.1:5500","http://rmtec.in:5500","http://192.168.0.118","http://192.168.0.139","http://192.168.0.139:8080","https://aishalaya.rosemallowtech.com:8080","https://aishalaya.rosemallowtech.com").allowedHeaders("*")
                        .allowCredentials(true).allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                        .exposedHeaders("Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Methods", "Access-Control-Allow-Headers");    //  .maxAge(3600);

            }
        };
    }
}