package com.example.Registration.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "API/v1/Student")
public class StudentController {
    private final StudentService studentService;
@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping
    public List<Student> students(){
        return studentService.students();
    }

    @PostMapping
    public void RegisterNewStudent(@RequestBody Student student){
    studentService.addNewStudent(student);

    }
}
