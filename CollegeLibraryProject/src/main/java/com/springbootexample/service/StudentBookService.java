package com.springbootexample.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexample.Repository.BookRepository;
import com.springbootexample.Repository.StudentBookRepository;
import com.springbootexample.Repository.StudentRepository;
import com.springbootexample.entity.Book;
import com.springbootexample.entity.Student;
import com.springbootexample.entity.StudentBook;

@Service
public class StudentBookService {

    
	
	@Autowired
	private StudentBookRepository sbRepo;
	
	@Autowired
	private BookRepository bRepo;
	
	@Autowired
	private StudentRepository sRepo;

   

	public String addBookToStudent(int sId, int bId) {
		Optional<Student> o1=sRepo.findBySId(sId);
		if(o1.isPresent()) {
			Optional<Book> o2=bRepo.findByBId(bId);
			if(o2.isPresent()) {
				Student s=o1.get();
				Book b=o2.get();
//				LocalDate date=LocalDate.now();
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			    String dateString = date.format(formatter);
				
				StudentBook sb=new StudentBook(s.getsId(),s.getsName(),s.getsBranch(),s.getsYearSem(),s.getsSec(),
						b.getbId(),b.getbName(),null,null,0);
				sbRepo.save(sb);
				sbRepo.setBookDate(sId,bId);
				return "BId: "+bId+" book added to sid:"+sId+" successfully";
			}
			else {
				return bId+" Book not exist";
			}
		}
		else {
			return sId+" Student not exist";
		}
		
	}

	public String returnBook(int sId, int bId) {
		Optional<Student> o1=sRepo.findBySId(sId);
		if(o1.isPresent()) {
			Optional<StudentBook> o2=sbRepo.findByBIdAndSIdAndBookStatus(bId,sId,"Not Returned");
			Optional<StudentBook> o3=sbRepo.findByBIdAndSIdAndBookStatus(bId, sId, "Returned");
			if(o2.isPresent()) {
				StudentBook sb=o2.get();
				sbRepo.setReturnDate(sId, bId);
//				int days=sbRepo.calculatePenality(sId, bId);
//				int penality=(days>15) ? days-15:0;
//				sb.setsBookPenality(penality);
//				sb.setBookStatus("Returned");
//				sbRepo.setReturnDate(sId, bId);
				sb.setsBookReturnDate(LocalDate.now());
				sbRepo.save(sb);
	            int days = sbRepo.calculatePenality(sId, bId);
	            int penality=(days>15)?days-15:0;
	            sb.setBookStatus("Returned");
	            sb.setsBookPenality(penality);
				sbRepo.save(sb);
				return bId+" book returned successfully";
			}
			else if(o3.isPresent()) {
				return bId+" book already returned";
			}
			else {
				return  bId+" Book not exist in your book taken list";
			}
			
		}
		else {
			return sId+" Student not exist";
		}
		
	}
	

	public String renualBook(int sId, int bId) {
		Optional<Student> o1=sRepo.findBySId(sId);
		if(o1.isPresent()) {
			Optional<StudentBook> o2=sbRepo.findByBIdAndSIdAndBookStatus(bId, sId, "Not Returned");
			Optional<StudentBook> o3=sbRepo.findByBIdAndSIdAndBookStatus(bId, sId, "Returned");
			if(o2.isPresent()) {
				StudentBook sb=o2.get();
				sb.setsBookReturnDate(LocalDate.now());
				sbRepo.save(sb);
				int days=sbRepo.calculatePenality(sId, bId);
				int penality=(days>15)?days-15:0;
				sb.setsBookPenality(penality);
				sbRepo.save(sb);
				
				sb.setsBookReturnDate(null);
				sbRepo.save(sb);
				return bId+" book renualed successfully";
				
			}
			else if(o3.isPresent() ) {
				return bId+" book already returned";
				
			}
			else {
				return bId+" Book not exist in your book taken list";
			}
		}
		else {
			return sId+" Student not exist";
		}
	}

	public List<StudentBook> studentData(int sId) {
		List<StudentBook> l=sbRepo.findStudentData(sId);
		return l;
		
		
	}

	public List<StudentBook> allData() {
		
		return sbRepo.findAll();
	}

}
