package com.springbootexample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexample.Repository.StudentRepository;
import com.springbootexample.entity.Student;

@Service
public class StudentService {


	@Autowired
	private StudentRepository repository;


	public String addStudent(Student s) {
		int sid=s.getsId();
		Optional<Student> o=repository.findBySId(sid);
		if(o.isEmpty()) {
			repository.save(s);
			return sid+" Student added successfully";
			
		}
		else {
			return sid+" student already exists";
		}
	}
	public String updateStudentAced(int sId, Student s) {
		Optional<Student> o=repository.findBySId(sId);
		if(o.isPresent()) {
			Student ns=o.get();
			ns.setsBranch(s.getsBranch());
			ns.setsYearSem(s.getsYearSem());
			ns.setsSec(s.getsSec());
			repository.save(ns);
			return sId+" Student academic detais updated successfully"; 
		}
		else {
			return sId+" Student not exists";
		}
		
	}
	
	public String updateStudentPers(int sId, Student s) {
		Optional<Student> o=repository.findBySId(sId);
		if(o.isPresent()) {
			Student ns=o.get();
			ns.setsName(s.getsName());
			ns.setsFatherName(s.getsFatherName());
			ns.setsDob(s.getsDob());
			ns.setsAge(s.getsAge());
			ns.setsPhone(s.getsPhone());
			ns.setsAddress(s.getsAddress());
			repository.save(ns);
			return sId+" Student personal detais updated successfully"; 
		}
		else {
			return sId+" Student not exists";
		}
		
	}

	public String deleteStudent(int sId) {
		
		Optional<Student> o=repository.findBySId(sId);
		if(o.isPresent()) {
			repository.delete(o.get());
			return sId+" Student deleted successfully"; 
		}
		else {
			return sId+" Student not exists";
		}
	}


}
