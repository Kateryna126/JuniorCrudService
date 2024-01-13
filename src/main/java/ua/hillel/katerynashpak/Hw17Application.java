package ua.hillel.katerynashpak;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import ua.hillel.katerynashpak.mapper.ProductMapper;
import ua.hillel.katerynashpak.mapper.ProductMapperImpl;

import java.util.Arrays;
@SpringBootApplication
public class Hw17Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Hw17Application.class, args);

        String[] beanNames = context.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
    @Bean
    public ProductMapper productMapper() {
        return new ProductMapperImpl();  // Припустимо, ProductMapperImpl - це згенерована реалізація MapStruct.
    }
    @Bean
    public Logger logger() {
        return LogManager.getLogger();
    }

}