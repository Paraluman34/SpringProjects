package com.training.n5sgms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.training.n5sgms.entity.Student;
import com.training.n5sgms.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET student by ID
    // URL: http://localhost:8090/api/students/1 tested in postman 200 OK
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // POST create new student
    // URL: http://localhost:8090/api/students tested in postman 200 OK
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    // PUT update student
    // URL: http://localhost:8090/api/students/{id} tested in postman 200 OK

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    // DELETE student
    // URL: http://localhost:8090/api/students/{id} tested in postman 204 No content
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}