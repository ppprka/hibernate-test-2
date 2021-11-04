import ru.innowise.danko.dao.impl.StudentDaoImpl;
import ru.innowise.danko.entity.RecordBook;
import ru.innowise.danko.entity.Student;
import ru.innowise.danko.entity.StudentGroups;
import ru.innowise.danko.service.StudentService;
import ru.innowise.danko.service.impl.StudentServiceImpl;
import ru.innowise.danko.util.HibernateSessionFactoryUtil;

import java.util.HashSet;
import java.util.Set;

public class HibernateRunner {
    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl(new StudentDaoImpl());

        Set<StudentGroups> studentGroups = new HashSet<>();

        StudentGroups studentGroups1 = StudentGroups.builder()
                .number("M1")
                .build();
        StudentGroups studentGroups2 = StudentGroups.builder()
                .number("M2")
                .build();
        studentGroups.add(studentGroups1);
        studentGroups.add(studentGroups2);

        Student student = Student.builder()
                .name("Paul")
                .surname("Danko")
                .studentGroups(studentGroups)
                .build();

        RecordBook recordBook = RecordBook.builder()
                .graduationYear("2020")
                .student(student)
                .studentGroups(studentGroups1)
                .build();

        student.setRecordBook(recordBook);


        studentService.addStudent(student);
/*        Student student1 = Student.builder()
                .name("Paul")
                .surname("Danko")
                .studentGroups(studentGroups)
                .build();
        studentService.addStudent(student1);*/
        Student student1 = Student.builder()
                .name("Mark")
                .surname("Quark")
                .studentGroups(studentGroups)
                .build();

        RecordBook recordBook1 = RecordBook.builder()
                .graduationYear("2020")
                .student(student)
                .studentGroups(studentGroups2)
                .build();

        student1.setRecordBook(recordBook);

        student1.setRecordBook(recordBook1);


        studentService.addStudent(student1);
    }
}
