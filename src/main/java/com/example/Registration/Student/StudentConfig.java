package com.example.Registration.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student aly = new Student(
                    "aly",
                    LocalDate.of(1997, Month.JANUARY, 11),
                    "aly@gmail.com"
            );
            Student amal = new Student(
                    "amal",
                    LocalDate.of(1990, Month.JANUARY, 11),
                    "amal@gmail.com"
            );
            repository.saveAll(List.of(aly, amal));
        };
    }
}