package org.zerogravitysolutions.digitalschooll.students;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Service
public interface StudentService {
     
    StudentEntity findById(Long id);
    Page<StudentEntity> findAll(Pageable pageable);
    void deleteById(Long id);
    StudentEntity update(StudentEntity studentEntity);
    StudentEntity create(StudentEntity studentEntity);
    List<StudentEntity> search(String keyword);
}
