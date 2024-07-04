/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.smartpro.config;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Arian
 */
@SpringBootApplication
public class WebConfig implements WebMvcConfigurer{

   
     
 @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                
                        registry.addMapping("/**")
                        .allowedOrigins("*") // Especifica el origen permitido
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                        .allowedHeaders("*") // Permitir todas las cabeceras
                        .allowCredentials(false); // Permitir credenciales
                        
                        /*
                        
                               registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000", "https://smart-pro.vercel.app/") // Especifica el origen permitido
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                        .allowedHeaders("*") // Permitir todas las cabeceras
                        .allowCredentials(true); // Permitir credenciales
                        */
           
            }
        };
    }
}
