package com.sda.javagda34.students.service;

import com.sda.javagda34.students.controller.StudentController;
import com.sda.javagda34.students.model.Student;
import com.sda.javagda34.students.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void update(Student student) {
        // zapis do bazy
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
