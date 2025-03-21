package org.zerogravitysolutions.digitalschooll.students;

//package org.zerogravitysolutions.digitalschooll.students.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/students/{id}")
    public StudentEntity findById(@PathVariable(name = "id") Long id) {
        return studentService.findById(id);
    }

    @GetMapping(path = "/students") 
    public List<StudentEntity> findAll() {
        return studentService.findAll();
    }

}
