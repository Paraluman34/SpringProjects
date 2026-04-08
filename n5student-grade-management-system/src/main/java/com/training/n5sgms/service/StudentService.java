package com.training.n5sgms.service;
import java.util.List;
import com.training.n5sgms.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    Student updateStudent(Long id,Student student);
    void deleteStudentById(Long id);
}
