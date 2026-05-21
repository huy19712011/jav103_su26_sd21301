package org.example.jav103_su26_sd21301.service;

import org.example.jav103_su26_sd21301.entity.Student;
import org.example.jav103_su26_sd21301.repository.StudentRepository;

import java.util.List;

public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();

    public List<Student> getStudents() {

        return studentRepository.getStudents();
    }

    public void addStudent(Student student) {

        studentRepository.addStudent(student);
    }
}
