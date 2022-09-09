package com.example.demo.Config;

import com.example.demo.Repositories.EmployeeRepo;
import com.example.demo.modells.ROLE;
import com.example.demo.modells.Employees;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@AllArgsConstructor
public class AuthConfig {

    @Bean
    CommandLineRunner commandLineRunner2(EmployeeRepo employeeRepo) {
        return args -> {
            Employees admin1 = new Employees(
                    "admin",
                    "admin",
                    ROLE.ROLE_ADMIN
            );
            Employees postman1 = new Employees(
                    "postman",
                    "postman",
                    ROLE.ROLE_POSTMAN
            );
            employeeRepo.saveAll(List.of(postman1,admin1));

        };
    }

}
