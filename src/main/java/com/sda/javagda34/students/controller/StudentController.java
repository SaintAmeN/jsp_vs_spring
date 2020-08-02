package com.sda.javagda34.students.controller;

import com.sda.javagda34.students.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String getStudentForm(Model model, Student student) {
        model.addAttribute("student", student);

        return "student_form";
    }

    @PostMapping("/student")
    public String updateStudent(Student student) {
        System.out.println("Dane: " + student);
        return "redirect:/student";
    }
}
