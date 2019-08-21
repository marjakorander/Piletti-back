package fi.academy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// @SpringBootApplication
// public class PilettiBackApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(PilettiBackApplication.class, args);
//     }

//     @Bean
//     public WebMvcConfigurer corsConfigurer() {
//         return new WebMvcConfigurerAdapter() {
//             @Override
//             public void addCorsMappings(CorsRegistry registry) {
//                 registry.addMapping("/").allowedOrigins("http://localhost:3000");
//             }
//         };
//     }
// }

@SpringBootApplication
public class PilettiBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PilettiBackApplication.class, args);
    }

    @EnableWebMvc
    public class MvcConfig implements WebMvcConfigurer {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/").allowedOrigins("http://localhost:3000");
            }
        };
}