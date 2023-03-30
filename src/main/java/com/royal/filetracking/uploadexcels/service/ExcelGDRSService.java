package com.royal.filetracking.uploadexcels.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelGDRSService {

	/**
	 * Check file format and convert excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	ResponseEntity<String> saveGDRSNewRegistration(MultipartFile file);

	
	
}
