package kz.team3.registration.Student;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents()

    {
        return List.of(
                new Student(
                        "190107034",
                        "Beka",
                        "Ganibek",
                        "190107034@stu.sdu.edu.kz",
                        "Information Systems",
                        4,
                        "+77086386314",
                        "Admin",
                        "777",
                        "ava.jpg"
                )
        );
    }
}
