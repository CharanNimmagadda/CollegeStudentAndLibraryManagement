package com.springbootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootexample.entity.StudentBook;
import com.springbootexample.service.StudentBookService;

@RestController
@RequestMapping("/library")
public class StudentBookController {
	
	@Autowired
	private StudentBookService service;

	@PutMapping("/addbooktostudent/{sId}/{bId}")
	public String addBookToStudent(@PathVariable int sId, @PathVariable int bId ) {
		return service.addBookToStudent(sId,bId);
	}
	
	@PutMapping("/returnbook/{sId}/{bId}")
	public String returnBook(@PathVariable int sId, @PathVariable int bId) {
		return service.returnBook(sId,bId);
	}
	
	@PutMapping("/renualbook/{sId}/{bId}")
	public String renualBook(@PathVariable int sId, @PathVariable int bId) {
		return service.renualBook(sId,bId);
	}
	
	@GetMapping("/studentdata/{sId}")
	public List<StudentBook> studentData(@PathVariable int sId) {
		return service.studentData(sId);
	}
	
	@GetMapping("/alldata")
	public List<StudentBook> allData() {
		return service.allData();
	}
	
	
}
