package com.sda.javagda34.students.controller;

import com.sda.javagda34.students.model.Grade;
import com.sda.javagda34.students.model.GradeSubject;
import com.sda.javagda34.students.model.Student;
import com.sda.javagda34.students.service.GradeService;
import com.sda.javagda34.students.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping(path = "/grade")
@RequiredArgsConstructor
public class GradeController {
    private final GradeService gradeService;
    private final StudentService studentService;

    @GetMapping()
    public String getGradeForm(Model model, Grade grade,
                               @RequestParam(name = "studentId", required = false) Long studentId) {
        model.addAttribute("grade", grade);
        model.addAttribute("studentId", studentId);
        model.addAttribute("allStudents", studentService.findAll());
        model.addAttribute("allSubjects", Arrays.asList(GradeSubject.values()));
        return "grade_form";
    }

    @PostMapping()
    public String submitGrade(Grade grade, Long studentId) {
        // po zatwierdzeniu formularza, należy powiązać encję studenta z oceną
        // w tym celu najpierw szukamy studenta (optional)
        Optional<Student> studentOptional = studentService.findById(studentId);
        if (studentOptional.isPresent()) { // jeśli uda się odnaleźć studenta
            Student student = studentOptional.get();// to wyciągamy go z optionala
            grade.setStudent(student);  // powiązujemy obiekty

            gradeService.update(grade);     // i zapisujemy ocenę w bazie

            return "redirect:/student/details?id=" + studentId; // na koniec redirect na stronę studenta.
        } else {
            return "redirect:/student/list";
        }
    }

    @GetMapping("/delete")
    public String deleteGrade(@RequestParam(name = "id") Long id,
                              @RequestParam(name = "studentId") Long studentId) {
        gradeService.deleteById(id);

        return "redirect:/student/details?id=" + studentId;
    }
}
