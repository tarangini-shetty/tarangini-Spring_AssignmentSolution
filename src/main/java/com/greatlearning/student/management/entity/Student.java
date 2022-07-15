package com.greatlearning.student.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentid")
	private int studentid = 0;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "course")
	private String course;
	@Column(name = "country")
	private String country;
	public Student(String firstname, String lastname, String course, String country) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.course = course;
		this.country = country;
	}
	
}

