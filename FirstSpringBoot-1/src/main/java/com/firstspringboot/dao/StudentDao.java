package com.firstspringboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.firstspringboot.entities.Student;

public interface StudentDao extends CrudRepository<Student, Integer>{

	
	
	
//	Custom Finder methods
	
	public List<Student> findByName(String name);
	
	
	
//	JPQL
	
	
	@Query("select s from Student s")
	public List <Student>getAllStu();
	
	
	@Query("select s from Student s where s.address=:x")
	public List <Student>getAllStu(@Param("x")String address);
	
	@Query(value = "select * from Student where id=:x",nativeQuery = true)
	public List<Student>getNativeStudent(@Param("x")int id);
	
	
	
	
	

	
}
