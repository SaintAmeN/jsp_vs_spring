package com.sda.javagda34.students.service;

import com.sda.javagda34.students.model.Grade;
import com.sda.javagda34.students.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeService {
    private final GradeRepository gradeRepository;

    public void update(Grade grade) {
        gradeRepository.save(grade);
    }

    public void deleteById(Long id) {
        gradeRepository.deleteById(id);
    }
}
