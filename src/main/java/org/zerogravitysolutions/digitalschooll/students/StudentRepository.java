package org.zerogravitysolutions.digitalschooll.students;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}