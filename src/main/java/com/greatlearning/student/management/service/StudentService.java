package com.greatlearning.student.management.service;

import java.util.List;

import com.greatlearning.student.management.entity.Student;


public interface StudentService {

	public List<Student> findAll();
    public Student findById(int id);
    public void save(Student student);
    public void deleteById(int id);
}
