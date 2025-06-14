package com.springbootexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootexample.entity.Student;
import com.springbootexample.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudnetController {
	
	@Autowired
	private StudentService service;

	@PostMapping("/addstudent")
	public String addStudent(@RequestBody Student s) {
		return service.addStudent(s);
	}
	
	@PutMapping("/updatestudentacademics/{sid}")
	public String updateStudentAced(@PathVariable int sid, @RequestBody Student s) {
		return service.updateStudentAced(sid,s);
	}
	
	@PutMapping("/updatestudentpersonal/{sid}")
	public String updateStudentPers(@PathVariable int sid, @RequestBody Student s) {
		return service.updateStudentPers(sid,s);
	}
	
	@DeleteMapping("/deletestudent/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		return service.deleteStudent(sid);
	}
}
