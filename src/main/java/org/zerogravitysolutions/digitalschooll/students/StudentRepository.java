package org.zerogravitysolutions.digitalschooll.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByFirstNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
}