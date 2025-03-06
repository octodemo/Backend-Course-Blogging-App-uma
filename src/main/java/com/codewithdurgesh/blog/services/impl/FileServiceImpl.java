package com.codewithdurgesh.blog.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codewithdurgesh.blog.services.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		// File name
		String name = file.getOriginalFilename();
		// abc.png

		// random name generate file
		String randomID = UUID.randomUUID().toString();
		String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));

		// Full path
		String filePath = path + File.separator + fileName1;

		// create folder if not created
		File f = new File(path);
		if (!f.exists()) {
			f.mkdir();
		}

		// file copy

		Files.copy(file.getInputStream(), Paths.get(filePath));

		return fileName1;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path + File.separator + fileName;
		InputStream is = new FileInputStream(fullPath);
		// db logic to return inpustream
		return is;
	}

	
		public static void SampleNestedIfMethod(String[] args) {
			int age = 25;
			String country = "USA";
			boolean hasPermission = true;
			boolean isMember = false;
			
			// Deeply nested conditionals
			if (age > 18) {
				if (country.equals("USA")) {
					if (hasPermission) {
						if (isMember) {
							System.out.println("Access granted: Adult from USA, with permission, and is a member.");
						} else {
							System.out.println("Access denied: Adult from USA, with permission, but not a member.");
						}
					} else {
						System.out.println("Access denied: Adult from USA, without permission.");
					}
				} else {
					System.out.println("Access denied: Adult, but not from USA.");
				}
			} else {
				System.out.println("Access denied: Underage.");
			}
		}
	
	

}
