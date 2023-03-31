package com.royal.filetracking.uploadexcels.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelGDRSService {

	/**
	 * GDRS New Registration 
	 * Convert New Registration excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	ResponseEntity<String> saveGDRSNewRegistration(MultipartFile file);

	/**
	 * Pending Supplier 
	 * convert Pending Supplier excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<String> saveGDRSPendingSupplier(MultipartFile file);

	/**
	 * Pending Registration
	 * convert Pending Registration excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	ResponseEntity<String> saveGDRSPendingRegistration(MultipartFile file);

	/**
	 * C and D
	 * convert C and D excel file to DB object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<String> saveGDRSCandD(MultipartFile file);

	
	
}
