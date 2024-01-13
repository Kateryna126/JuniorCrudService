package ua.hillel.katerynashpak.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
@Configuration
public class DatabaseBeanConfig {
@Bean
        public DataSource dataSource() {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setDriverClassName("org.postgresql.Driver");
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/Hillel_JavaPro");
            dataSource.setUsername("postgres");
            dataSource.setPassword("852456");

            return dataSource;
        }

    }

