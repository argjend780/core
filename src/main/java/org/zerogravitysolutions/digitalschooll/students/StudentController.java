package org.zerogravitysolutions.digitalschooll.students;

//package org.zerogravitysolutions.digitalschooll.students.StudentRepository;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.RequestParam;


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
    public Page<StudentEntity> findAll(Pageable pageable) {
        return studentService.findAll(pageable);
    }
    @PostMapping(path = "/students")
    @ResponseStatus(HttpStatus.CREATED) // 201 Created
    public StudentEntity create(@RequestBody @Valid StudentEntity studentEntity) {
        return studentService.create(studentEntity);

    }

    @GetMapping(path = "/students/serach") 
    public List<StudentEntity> findByNameOrEmail(@RequestParam(name ="keyword", required = false) @Size(min=3) String keyword){
     if(keyword == null || keyword.trim().isEmpty()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Keyword must not be empty");
     }
    /*  if(keyword.length() < 3){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Keyword must be at least 3 characters long");    

     }*/
        return studentService.search(keyword);
    }
}
