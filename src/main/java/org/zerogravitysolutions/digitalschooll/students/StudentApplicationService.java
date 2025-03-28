package org.zerogravitysolutions.digitalschooll.students;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


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

    @Override
    public void deleteById(Long id) {
        StudentEntity studentEntity = studentRepository.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student "+id +"not found")
        );
        studentEntity.setDeletedAt(LocalDateTime.now()); // Set the deletion timestamp
        studentEntity.setDeletedBy(1L); // Set the ID of the user who deleted the record (for example, admin)
       
        studentRepository.delete(studentEntity);
    }
    @Override
    public StudentEntity update(StudentEntity studentEntityRequest) {
        studentRepository.findById(studentEntityRequest.getId()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student "+ studentEntityRequest.getId() +"not found")
        );
        studentEntityRequest.setUpdatedAt(LocalDateTime.now()); // Set the update timestamp
        studentEntityRequest.setUpdatedBy(1L); // Set the ID of the user who updated the record (for example, admin)
        return studentRepository.save(studentEntityRequest);
    }
    /*@Override
    public StudentEntity uptdate(StudentEntity studentEntityRequest) {
        studentRepository.findById(studentEntityRequest.getId()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student "+ studentEntityRequest.getId() +"not found")
        );
        studentEntityRequest.setUpdatedAt(LocalDateTime.now()); // Set the update timestamp
        studentEntityRequest.setUpdatedBy(1L); // Set the ID of the user who updated the record (for example, admin)
        return studentRepository.save(studentEntityRequest);
    }*/
    
}
