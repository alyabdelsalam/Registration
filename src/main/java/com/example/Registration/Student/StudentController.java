package com.example.Registration.Student;

import jakarta.transaction.Transactional;
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
@DeleteMapping(path = "{StudentId}")
    public void DeleteStudent(@PathVariable("StudentId") Long StudentId){
    studentService.DeleteStudent(StudentId);

}
@PutMapping(path = "{StudentId}")
public void UpdateStudent(
        @PathVariable("StudentId")Long StudentId,
        @RequestParam(required = false)String name,
        @RequestParam(required = false)String email){
    studentService.UpdateStudent(StudentId,name,email);

}
}
