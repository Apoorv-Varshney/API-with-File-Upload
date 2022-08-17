package com.student.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String DIR = "D:\\workspace\\FileUpload\\src\\main\\resources\\static\\images";
	public final String DIR= new ClassPathResource("static/images/").getFile().getAbsolutePath();

	
	public FileUploadHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean upload(MultipartFile file) {
		boolean result = false;
		try {
			Files.copy(file.getInputStream(), Paths.get(DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
