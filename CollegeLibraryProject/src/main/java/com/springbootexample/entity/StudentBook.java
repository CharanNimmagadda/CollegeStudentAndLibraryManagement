package com.springbootexample.entity;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srNo;
	
	private int sId;
	private String sName;
	private String sBranch;
	private String sYearSem;
	private int sSec;
	
	private int bId;
	private String bName;
	private LocalDate sBookTakenDate;
	private LocalDate sBookReturnDate;
	//@Column(columnDefinition = "VARCHAR(20) DEFAULT 'Not Returned'")
	private String bookStatus="Not Returned";
	private int sBookPenality;
	
	
	
	
	
	public StudentBook() {
		super();
	}
	
	
	
	public StudentBook(int sId, String sName, String sBranch, String sYearSem, int sSec, int bId,
			String bName, LocalDate sBookTakenDate, LocalDate sBookReturnDate, int sBookPenality) {
		super();
		
		this.sId = sId;
		this.sName = sName;
		this.sBranch = sBranch;
		this.sYearSem = sYearSem;
		this.sSec = sSec;
		this.bId = bId;
		this.bName = bName;
		this.sBookTakenDate = sBookTakenDate;
		this.sBookReturnDate = sBookReturnDate;
//		this.bookStatus = bookStatus;
		this.sBookPenality = sBookPenality;
	}



	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsBranch() {
		return sBranch;
	}
	public void setsBranch(String sBranch) {
		this.sBranch = sBranch;
	}
	public String getsYearSem() {
		return sYearSem;
	}
	public void setsYearSem(String sYearSem) {
		this.sYearSem = sYearSem;
	}
	public int getsSec() {
		return sSec;
	}
	public void setsSec(int sSec) {
		this.sSec = sSec;
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
	public LocalDate getsBookTakenDate() {
		return sBookTakenDate;
	}
	public void setsBookTakenDate(LocalDate sBookTakenDate) {
		this.sBookTakenDate = sBookTakenDate;
	}
	public LocalDate getsBookReturnDate() {
		return sBookReturnDate;
	}
	public void setsBookReturnDate(LocalDate sBookReturnDate) {
		this.sBookReturnDate = sBookReturnDate;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public int getsBookPenality() {
		return sBookPenality;
	}
	public void setsBookPenality(int sBookPenality) {
		this.sBookPenality = sBookPenality;
	}
	
	
	
	
	

}
