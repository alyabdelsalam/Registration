package com.example.Registration.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class StudentService {
    public List<Student> students(){
        return List.of(
                new Student(
                        1l,
                        "aly mohamed",
                        LocalDate.of(1997, Month.JANUARY,11),
                        "aly@gmail.com",
                        26


                )
        );
    }
}
