package com.springbootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootexample.entity.Book;
import com.springbootexample.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService service;

	@PostMapping("/addbook")
	public String addBook(@RequestBody Book b) {
		int bId =b.getbId();
		return service.addBook(b,bId);
	}
	
	//@PutMapping("/updatebook/{bId}/{bCount}")
	//public String updateBook(@PathVariable int bId, @PathVariable int bCount) {   (or)
	@PutMapping("/updatebook{bId}{bCount}")
//	public String updateBook(@RequestParam int bId, @RequestParam int bCount) {
//		return service.updateBook(bId,bCount);
//	}
	
	@DeleteMapping("/deletebook")
	public String removeBook() {
		return "working";
//		return service.removeBook(bId);
	}
	
	@GetMapping("/getbookbyid/{bId}")
	public Book getBookById(@PathVariable int bId) {
		return service.getBookById(bId);
	}
	
	@GetMapping("/getbookbyname/{bName}")
	public Book getBookByBname(@PathVariable String bName) {
		return service.getBookByBname(bName);
	}
	
	@GetMapping("/getbooks")
	public List<Book> getBooks(){
		return service.getBooks();
	}
	
	@GetMapping("/bookscount")
	public String getBookCount() {
		return service.getBookCount();
	}
	
	@GetMapping("/totalbooksprice")
	public String getTotalBookPrice() {
		return service.getTotalBookPrice();
	}
	
}
