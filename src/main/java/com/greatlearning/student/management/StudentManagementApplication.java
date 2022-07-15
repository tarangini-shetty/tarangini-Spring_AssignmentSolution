package com.greatlearning.student.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.student.management.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
