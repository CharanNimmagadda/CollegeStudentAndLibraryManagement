package com.springbootexample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	
//	@Column(nullable = false)
	//@JsonProperty("bid")
	private int bId;
	
//	@Column(nullable = false)
	//@JsonProperty("bname")
	private String bName;
	
	//@JsonProperty("bauthor")
//	@Column(nullable = false)
	private String bAuthor;
	
	//@JsonProperty("bprice")
//	@Column(nullable = false)
	private int bPrice;
	
	
	
	
	
	public Book() {
		super();
	}
	
	public Book(int bId, String bName, String bAuthor, int bPrice) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPrice = bPrice;
		
	}


	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getbAuthor() {
		return bAuthor;
	}
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	public int getbPrice() {
		return bPrice;
	}
	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}
	
	
	

}



