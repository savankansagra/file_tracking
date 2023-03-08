package com.royal.filetracking.tryone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryone.helper.ExcelHelper;
import com.royal.filetracking.tryone.model.Tutorial;
import com.royal.filetracking.tryone.service.ExcelService;

@Controller
@RequestMapping("/api/excel")
public class ExcelController {

	@Autowired
	ExcelService excelService;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ){
		String message = "";
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				excelService.save(file);
				message = "file uploaded succesfully.";
				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			} catch (Exception e) {
				message = "Could not upload the file.";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
			}
		}
		message = "Please upload an excel file !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}

	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials() {
		try {
			List<Tutorial> allTutorials = excelService.getAllTutorials();
			if(allTutorials.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(allTutorials);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	
}
