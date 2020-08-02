package com.sda.javagda34.students.controller;

import com.sda.javagda34.students.model.Student;
import com.sda.javagda34.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // automatycznie robi autowired
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @GetMapping()
    public String getStudentForm(Model model, Student student) {
        model.addAttribute("student", student);

        return "student_form";
    }

    @PostMapping()
    public String updateStudent(Student student) {
        System.out.println("Dane: " + student);
        studentService.update(student);
        return "redirect:/student/list";
    }

    // localhost:8080/student/list
    @GetMapping("/list")
    public String listStudents(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);

        return "student_list";
    }

    // localhost:8080/student/details?id=1
    @GetMapping("/details")
    public String getDetailsPage(Model model, @RequestParam(name = "id") Long id) {
        Optional<Student> studentOptional = studentService.findById(id);
        if (studentOptional.isPresent()) { // jeśli uda się znaleźć studenta, to wyświetlimy widok szczegółowy
            Student student = studentOptional.get();
            model.addAttribute("student", student);

            return "student_details";
        } else {
            // nie uda się odnaleźć studenta to przekierowujemy z powrotem na listę
            return "redirect:/student/list";
        }
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam(name = "id") Long id){
        studentService.deleteById(id);

        return "redirect:/student/list";
    }
}
