package ru.innowise.danko.service;

import ru.innowise.danko.entity.Student;

import java.util.List;

public interface StudentService {

    void addStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
