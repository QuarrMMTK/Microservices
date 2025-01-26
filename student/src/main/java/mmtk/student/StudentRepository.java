package mmtk.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author : Min Myat Thu Kha
 * Created At : 25/01/2025, Jan
 * Project Name : Microservices
 **/
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllBySchoolId(Integer schoolId);
}
