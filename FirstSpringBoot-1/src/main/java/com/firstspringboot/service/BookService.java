package com.firstspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.firstspringboot.dao.BookDao;
import com.firstspringboot.entities.Book;

@Component

public class BookService {

	@Autowired
	private BookDao bookDao;
	
	
	
	
	
	public  List<Book>getAllBooks()
	{
		
		List<Book> list=(List<Book>)this.bookDao.findAll();
		
		return list;
	}
	
	public Optional<Book> getBook(int id)
	{
		Optional<Book> b=this.bookDao.findById(id);
		
		return b;
		
	}
	
	
	public void addBooks(Book b)
	{
		Book b1=this.bookDao.save(b);
		
	}
	
	public void delBook(int id)
	{
		
		this.bookDao.deleteById(id);
	}
//	public void updateBook(Book b,int id)
//	{
//		
//		Book b1=list.stream().filter(book->book.getBid()==id).findFirst().get();
//		list.remove(b1);
//		list.add(b);
//		
//		
//		
//	}This is another way of updating 
	
	public void updateBook1(Book b,int id)
	{
		
		
		b.setBid(id);
		this.bookDao.save(b);
				
				
				
				
				
		
		
		
	}
	
	
	
}
