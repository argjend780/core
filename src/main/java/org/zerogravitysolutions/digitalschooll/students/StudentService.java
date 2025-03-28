package org.zerogravitysolutions.digitalschooll.students;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
     
    StudentEntity findById(Long id);
    List<StudentEntity> findAll();
    void deleteById(Long id);
    StudentEntity update(StudentEntity studentEntity);

}
