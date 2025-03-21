package org.zerogravitysolutions.digitalschooll.students;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.stereotype.Service;

@Service
public class StudentApplicationService implements StudentService{


    private final StudentRepository studentRepository;
    
    public StudentApplicationService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentEntity findById(Long id) {

       /*  Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        StudentEntity studentEntity = optionalStudentEntity.orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student "+id +"not found")
        );
        return studentEntity;*/
        return studentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student "+id +"not found")
        );
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    } 

    
}
