package com.firstspringboot.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileOperation {
	
	
	public boolean sendFile(MultipartFile multipartFile) throws IOException
	{
		
//		String path="D:\\Eclipse\\FirstSpringBoot-1\\src\\main\\resources\\static";
		String path=new ClassPathResource("static/img/").getFile().getAbsolutePath();
		
		
		boolean done=false;
		
		
		try {
			
			
			Files.copy(multipartFile.getInputStream(),Paths.get(path+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			
			done=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return done;
		
	}
	
	
	

}
