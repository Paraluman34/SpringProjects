package com.training.n5sgms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;

@Entity
@Table(name="students")

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "First name is required")
	@Column(name = "first_name", nullable=false)
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	@Column(name = "last_name", nullable=false)
	private String lastName;
	
	@NotNull(message = "Grade is required")
    @Min(value = 1, message = "Grade must be at least 1")
    @Max(value = 100, message = "Grade must not exceed 100")
	@Column(name = "grade")
	private String grade;
	
	public Student() {
	}
	public Student(String firstName, String lastName, String grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}

