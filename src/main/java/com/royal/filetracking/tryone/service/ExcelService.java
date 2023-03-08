package com.royal.filetracking.tryone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryone.helper.ExcelHelper;
import com.royal.filetracking.tryone.model.Tutorial;
import com.royal.filetracking.tryone.repository.TutorialRepository;

@Service
public class ExcelService {

	@Autowired
	TutorialRepository repository;
	
	public void save(MultipartFile file) {
		try {
			List<Tutorial> tutorials = ExcelHelper.excelToTutorials(file.getInputStream());
			repository.saveAll(tutorials);
		} catch (Exception e) {
			
		}
	}
	
	public List<Tutorial> getAllTutorials(){
		return repository.findAll();
	}
		
}
