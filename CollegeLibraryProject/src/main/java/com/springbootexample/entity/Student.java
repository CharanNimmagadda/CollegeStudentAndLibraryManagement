package com.springbootexample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recordId;
	
	@JsonProperty("sid")
	@Column(nullable = false,unique = true)
	private int sId;
	
	@JsonProperty("sname")
	private String sName;
	private String sDob;
	private int sAge;
	private String sFatherName;
	private String sBranch;
	private String sYearSem;
	private int sSec;
	private long sPhone;
	private String sAddress;
	public int getRecordId() {
		return recordId;
	}
	
	public Student() {
		super();
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
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
	public String getsDob() {
		return sDob;
	}
	public void setsDob(String sDob) {
		this.sDob = sDob;
	}
	public int getsAge() {
		return sAge;
	}
	public void setsAge(int sAge) {
		this.sAge = sAge;
	}
	public String getsFatherName() {
		return sFatherName;
	}
	public void setsFatherName(String sFatherName) {
		this.sFatherName = sFatherName;
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
	public long getsPhone() {
		return sPhone;
	}
	public void setsPhone(long sPhone) {
		this.sPhone = sPhone;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
}
