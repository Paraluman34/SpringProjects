package com.training.n5sgms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.n5sgms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}