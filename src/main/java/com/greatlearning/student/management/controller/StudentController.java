package com.greatlearning.student.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.student.management.entity.Student;
import com.greatlearning.student.management.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	
	@RequestMapping("/list")
	public String showStudents(Model model) {
		List<Student> students = studentService.findAll();
		model.addAttribute("students",students);
		return "student-list";
	}
	
	@RequestMapping("/showFormForAdd") 
	public String showFormForAdd(Model model)
	{
		Student student = new Student();
		model.addAttribute("student",student);
		model.addAttribute("mode","Add");
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate") 
	public String showFormForUpdate(@RequestParam("studentId") int studentid, Model model)
	{
		Student student = studentService.findById(studentid);
		model.addAttribute("student",student);
		model.addAttribute("mode","Update");
		return "student-form";

				
	}
	
	@PostMapping("/save") 
	public String saveStudent(@RequestParam("studentid") int studentid, 	@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("course") String course, @RequestParam("country") String country )
	{
		Student student = null;
		if(studentid == 0)
		{
			student = new Student(firstname, lastname, course, country);
		}
		else
		{
			student = studentService.findById(studentid);
			student.setFirstname(firstname);
			student.setLastname(lastname);
			student.setCourse(course);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:/students/list";
		
	}
	
	@RequestMapping("/delete") 
	public String delete(@RequestParam("studentId") int studentid)
	{
		studentService.deleteById(studentid);
		return "redirect:/students/list";

	}
	
	
	@RequestMapping("/403")
	public String show403(Model model) {
		return "403";
	}
	
	
}
