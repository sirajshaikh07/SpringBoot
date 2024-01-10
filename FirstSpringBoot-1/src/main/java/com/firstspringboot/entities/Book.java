package com.firstspringboot.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	
	private String bname;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author bauthor;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Author getBauthor() {
		return bauthor;
	}
	public void setBauthor(Author bauthor) {
		this.bauthor = bauthor;
	}
	public Book(int bid, String bname, Author bauthor) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bauthor = bauthor;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + "]";
	}
	
	
	
}
