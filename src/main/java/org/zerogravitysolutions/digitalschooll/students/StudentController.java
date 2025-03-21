package org.zerogravitysolutions.digitalschooll.students;

//package org.zerogravitysolutions.digitalschooll.students.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
@RestController
public class StudentController {
    
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @GetMapping(path = "/students")
    public List<StudentEntity> findAll(){
        return  studentRepository.findAll();
    }

}
