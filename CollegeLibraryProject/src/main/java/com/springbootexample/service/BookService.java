package com.springbootexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootexample.Repository.BookRepository;

import com.springbootexample.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;


	public String addBook(Book b,int bId) {
		
		Optional<Book> b1= repository.findByBId(bId);
		
		if(b.getbId()==0 || b.getbName()==null || b.getbAuthor()==null || b.getbPrice()==0 ) {
			return "Enter complete Book Details";
		}
		
		if(b1.isPresent()) {
			return bId+" Book already Exist";
		}
		
		else {
			repository.save(b);
			return "successfully Book "+b.getbName()+ " Added";
		}
		
	}


	


	public String removeBook(int bId) {
		Optional<Book> o=repository.findByBId(bId);
		if(o.isPresent()) {
			Book bNew=o.get();
			repository.delete(bNew);
			return bNew.getbName()+" deleted successfully";
		}
		else {
			return "Enter valid Book Id";
		}
	}



	public Book getBookById(int bId) {
		Optional<Book> o=repository.findByBId(bId);
		if(o.isPresent()) {
			Book bNew=o.get();
			return bNew;
		}
		else {
			return null;
		}
	}

	public Book getBookByBname(String bname) {
		Optional<Book> o=repository.findByBName(bname);
		if(o.isPresent()) {
			Book b=o.get();
			return b;
		}
		else {
			return null;
		}
	}


	public List<Book> getBooks() {
		return repository.findAll();
	}



	public String getBookCount() {
		List<Book> l=repository.findAll();
		int n=l.size();
		return "Total books are: "+n;
	}



	public String getTotalBookPrice() {
		List<Book> l=repository.findAll();
		int total=0;
		for(Book b:l) {
			total+=b.getbPrice();
		}
		return "Total cost of all books is: "+total;
	}


	
}
