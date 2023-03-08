package com.royal.filetracking.tryTwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryTwo.service.ExcelGDRSService;


@Controller
@RequestMapping("api/excel/v2/gdrs")
public class ExcelGDRSController {
	
	@Autowired
	ExcelGDRSService excelGDRSService;
	
	@PostMapping("/new registration/upload")
	public ResponseEntity<String> uploadGDRSNewRegistration(@RequestParam("file") MultipartFile file){
		return excelGDRSService.saveGDRSNewRegistration(file);
	}
	
}
