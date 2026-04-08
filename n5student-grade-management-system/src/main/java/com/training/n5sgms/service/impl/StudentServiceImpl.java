package com.training.n5sgms.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.training.n5sgms.entity.Student;
import com.training.n5sgms.exception.StudentNotFoundException;
import com.training.n5sgms.repository.StudentRepository;
import com.training.n5sgms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setGrade(student.getGrade());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
        studentRepository.delete(existingStudent);
    }

}