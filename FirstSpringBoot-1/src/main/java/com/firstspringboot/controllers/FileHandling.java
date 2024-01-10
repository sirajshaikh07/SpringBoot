package com.firstspringboot.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firstspringboot.helper.FileOperation;

@RestController
public class FileHandling {
	
	
	@Autowired
	private FileOperation fileOperation;
	@PostMapping("/file-uplode")
	public ResponseEntity<String>getFile(@RequestParam("f") MultipartFile file) throws IOException
	{
		
		boolean done=fileOperation.sendFile(file);
		if(done)
		{
			
			return ResponseEntity.ok("File Uploded Successfully");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not Uploded PLease Try Again");	
	}
	
	
}
