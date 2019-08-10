package com.sms.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.registration.dao.StudentDAO;
import com.sms.registration.model.Student;
import com.sms.registration.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	StudentRepository stRepo;
	
	@RequestMapping("/")
	public String home() {
		return "register.jsp";
	}
	
	@RequestMapping("/registerStudent")
	public String addStudent(Student student) {
		StudentDAO S=new StudentDAO();
		Student st=S.insertStudent(student);
		stRepo.save(st);
		return "register.jsp";
	}
}