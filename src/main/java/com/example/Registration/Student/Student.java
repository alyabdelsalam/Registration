package com.example.Registration.Student;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private LocalDate DOB;
    private String email;
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, LocalDate DOB, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.age = age;
    }

    public Student(String name, LocalDate DOB, String email, Integer age) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
