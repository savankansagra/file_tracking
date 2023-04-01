package com.royal.filetracking.uploadexcels.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.uploadexcels.service.ExcelGDRSService;
import com.royal.filetracking.uploadexcels.service.impl.ExcelGDRSServiceImpl;
import com.royal.filetracking.uploadexcels.utils.Constant;


@RestController
@CrossOrigin
@RequestMapping(Constant.GDRS_END_POINT)
public class GDRSController {
	
	public final Logger logger = LoggerFactory.getLogger(GDRSController.class);
	
	@Autowired
	ExcelGDRSService excelGDRSService;
	
	/**
	 * New Registration file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/new_registration")
	public ResponseEntity<Map<?, ?>> uploadGDRSNewRegistration(@RequestParam("file") MultipartFile file){
		logger.info("GDRS New Registration : uploading file... ");
		return excelGDRSService.saveGDRSNewRegistration(file);
	}
	
	/**
	 * Pending Supplier file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/pending_sup")
	public ResponseEntity<Map<?, ?>> uploadGDRSPendingSupplier(@RequestParam("file") MultipartFile file){
		logger.info("GDRS Pending Supplier : uploading file... ");
		return excelGDRSService.saveGDRSPendingSupplier(file);
	}

	/**
	 * Pending Registration file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/pending_reg")
	public ResponseEntity<Map<?, ?>> uploadGDRSPendingRegistration(@RequestParam("file") MultipartFile file){
		logger.info("GDRS Pending Registration : uploading file...");
		return excelGDRSService.saveGDRSPendingRegistration(file);
	}
	
	/**
	 * C and D Sent file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/c_and_d_sent")
	public ResponseEntity<Map<?, ?>> uploadGDRSCandDSentRegistration(@RequestParam("file") MultipartFile file){
		logger.info("GDRS C and D Sent : uploading file...");
		return excelGDRSService.saveGDRSCandDSent(file);
	}
	
	/**
	 * C and D Cleared file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/c_and_d_cleared")
	public ResponseEntity<Map<?, ?>> uploadGDRSCandDClearedRegistration(@RequestParam("file") MultipartFile file){
		logger.info("GDRS C and D Cleared : uploading file...");
		return excelGDRSService.saveGDRSCandDCleared(file);
	}
	
	/**
	 * Received for correction file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/received_for_correction")
	public ResponseEntity<Map<?, ?>> uploadGDRSReceivedForCorrection(@RequestParam("file") MultipartFile file) {
		logger.info("GDRS received for correction : uploading file...");
		return excelGDRSService.saveGDRSReceivedForCorrection(file);
	}
	
}
