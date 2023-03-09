package com.royal.filetracking.tryTwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryTwo.service.ExcelGDRSService;


@Controller
@RequestMapping("/api/excel/v2/gdrs")
@CrossOrigin
public class ExcelGDRSController {
	
	@Autowired
	ExcelGDRSService excelGDRSService;

	
	/**
	 * GDRS New Registration upload excel file.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/new registration/upload")
	public ResponseEntity<String> uploadGDRSNewRegistration(@RequestParam("file") MultipartFile file){
		return excelGDRSService.saveGDRSNewRegistration(file);
	}
	
	
	/**
	 * GDRS Pending Supplier file upload.
	 * 
	 * @param pendingSupplierFile
	 * @return
	 */
	@PostMapping("/pendingsupplier/upload")
	public ResponseEntity<String> uploadGDRSPendingSupplierFile(@RequestParam("file") MultipartFile pendingSupplierFile){
		return excelGDRSService.saveGDRSPendingSupplier(pendingSupplierFile);
	}
	
	
	@GetMapping("/")
	public String getHtmlPage(Model model) {
		return "gdrs";
	}
}
