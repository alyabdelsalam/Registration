package com.example.Registration.Student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Autowired

    public List<Student> students() {
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {
        Optional<Student> StudentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (StudentByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

    }

    public void DeleteStudent(Long StudentId) {

        boolean exists = studentRepository.existsById(StudentId);
        if (!exists) {
            throw new IllegalStateException("student id " + StudentId + " does not exists");
        }
        studentRepository.deleteById(StudentId);
    }

    @Transactional
    public void UpdateStudent(Long StudentId, String name, String email) {
        Student student = studentRepository.
                findById(StudentId).orElseThrow(() -> new IllegalStateException(
                        "student with id " + StudentId + " does not exist"
                ));
        if (
                name != null && name.length() > 0 &&
                        !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (
                email != null && email.length() > 0 &&
                        !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }
    }
}