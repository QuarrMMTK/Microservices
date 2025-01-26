package mmtk.school.client;

import mmtk.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Author : Min Myat Thu Kha
 * Created At : 25/01/2025, Jan
 * Project Name : Microservices
 **/
@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    List<Student> getStudent(@PathVariable("school-id") Integer schoolId);

}
