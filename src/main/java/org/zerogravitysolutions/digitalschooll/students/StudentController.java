package org.zerogravitysolutions.digitalschooll.students;

//package org.zerogravitysolutions.digitalschooll.students.StudentRepository;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;

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
    
    @DeleteMapping(path = "/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204 No Content
    public void deleteById(@PathVariable(name = "id") Long id) {
        studentService.deleteById(id);
    }

    @PutMapping(path = "/students/{id}")
    public StudentEntity update(@Valid @RequestBody StudentEntity studentEntity, 
                                @PathVariable(name = "id") Long id) {
        if(!id.equals(studentEntity.getId())){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID in path and body do not match"); 
        }
        return studentService.update(studentEntity);
    }

    @GetMapping(path = "/students") 
    public List<StudentEntity> findAll() {
        return studentService.findAll();
    }

}
