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

	/**
	 * GWORKS TPA Cleared
	 * Convert TPA Cleared excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveTPACleared(MultipartFile file);

	/**
	 * GWORKS Inspection Sent
	 * Convert Inspection sent excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveInspectionSent(MultipartFile file);

	/**
	 * GWORKS Inspection Not installed
	 * Convert Inspection not installed excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveInspNotInstalled(MultipartFile file);

	/**
	 * GWORKS Inspection installed
	 * Convert Inspection install excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveInspCleared(MultipartFile file);
	
}
