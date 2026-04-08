package com.training.n5sgms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@Pattern(regexp = "^[A-Za-z]+$", message = "First name must contain only letters")
	@Column(name = "first_name", nullable=false)
	private String firstName;
	
	@NotBlank(message = "Last name is required")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Last name must contain only letters")
	@Column(name = "last_name", nullable=false)
	private String lastName;
	
	@NotNull(message = "Grade is required")
    @Min(value = 1, message = "Grade must be at least 1")
    @Max(value = 100, message = "Grade must not exceed 100")
	@Column(name = "grade")
	private Integer grade;
	private String status;

	public Student() {
	}
	public Student(String firstName, String lastName, Integer grade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.status = (grade >= 75) ? "Pass" : "Fail";
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
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
		    this.grade = grade;
            this.status = (grade >= 75) ? "Pass" : "Fail";
	}
	public String getStatus() {
		return status;
	}
}

//you can also use lombok