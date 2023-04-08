package com.royal.filetracking.uploadexcels.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelGWORKSService {

	/**
	 * GWORKS Work Order Received
	 * Convert Work Order Received excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveWorkOrderReceived(MultipartFile file);

	/**
	 * GWORKS TPA Sent
	 * Convert TPA Sent excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveTPASent(MultipartFile file);

	
	
	
	
}
