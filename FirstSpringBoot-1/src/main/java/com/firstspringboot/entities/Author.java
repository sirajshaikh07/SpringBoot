package com.firstspringboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Author {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

 private int aid;
 private String aname;
 @OneToOne(mappedBy = "bauthor")
 @JoinColumn(name = "bookid")
 @JsonBackReference
 private Book b;
public Book getB() {
	return b;
}
public void setB(Book b) {
	this.b = b;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public Author() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
}
