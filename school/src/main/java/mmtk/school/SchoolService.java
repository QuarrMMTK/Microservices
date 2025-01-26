package mmtk.school;

import lombok.RequiredArgsConstructor;
import mmtk.school.client.StudentClient;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : Min Myat Thu Kha
 * Created At : 25/01/2025, Jan
 * Project Name : Microservices
 **/
@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient client;


    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        if (client == null) {
            throw new IllegalStateException("StudentClient is not injected!");
        }
        var school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build());
        var students = client.getStudent(schoolId);
        return FullSchoolResponse
                .builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
