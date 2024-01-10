package com.firstspringboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstspringboot.entities.Book;
import com.firstspringboot.service.BookService;

@RestController
public class BookController {

	@Autowired
	public BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> allBook()
	{
		
		List<Book> list=null;
		list=bookService.getAllBooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
		
	}
	
	@GetMapping("/book/{id}")
	public Optional<Book> singleBook(@PathVariable("id")int id)
	{
		
		
		return bookService.getBook(id);
	}
	
	@PostMapping("/book")
	public void addBook(@RequestBody Book b)
	{
		
		bookService.addBooks(b);
		System.out.println(b.toString());
	}
	
	@DeleteMapping("/book/{id}")
	public void delBook(@PathVariable("id")int id)
	{
		
		bookService.delBook(id);
		
	}
	@PutMapping("/book/{id}")
	public String updateBook(@RequestBody Book b,@PathVariable("id")int id)
	{
		
		bookService.updateBook1(b,id);
	
		return "Update successfully";
	}
	
	
	
	
}
