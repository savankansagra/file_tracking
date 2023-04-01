package com.royal.filetracking.uploadexcels.service;

import java.util.Map;

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
	ResponseEntity<Map<?, ?>> saveGDRSNewRegistration(MultipartFile file);

	/**
	 * Pending Supplier 
	 * convert Pending Supplier excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveGDRSPendingSupplier(MultipartFile file);

	/**
	 * Pending Registration
	 * convert Pending Registration excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveGDRSPendingRegistration(MultipartFile file);

	/**
	 * C and D Sent
	 * convert C and D Sent excel file to DB object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveGDRSCandDSent(MultipartFile file);

	/**
	 * C and D Cleared
	 * convert C and D Cleared excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveGDRSCandDCleared(MultipartFile file);

	/**
	 * Received for correction
	 * convert received for correction excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveGDRSReceivedForCorrection(MultipartFile file);

	
	
}
