package com.firstspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.firstspringboot.entities.Book;

@Component
public interface BookDao extends CrudRepository<Book, Integer>{
	
	

}
