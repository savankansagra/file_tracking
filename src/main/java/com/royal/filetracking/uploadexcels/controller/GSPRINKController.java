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

import com.royal.filetracking.uploadexcels.service.ExcelGSPRINKService;
import com.royal.filetracking.uploadexcels.utils.Constant;

@RestController
@CrossOrigin
@RequestMapping(path = Constant.GSPRINK_END_POINT)
public class GSPRINKController {

	public final Logger	logger = LoggerFactory.getLogger(GSPRINKController.class);
	
	@Autowired
	ExcelGSPRINKService excelGSPRINGService;
	
	/**
	 * GSPRINK Pending Supplier file upload. 
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/pending_sup")
	public ResponseEntity<Map<?, ?>> uploadGSPRINKPendingSupplier(@RequestParam("file") MultipartFile file){
		logger.info("GSPRINK Pending Supplier : uploading file... ");
		return excelGSPRINGService.saveGSPRINKPendingSupplier(file);
	}
	
	
	/**
	 * GSPRINK Registration C & D Pending file upload.
	 * 
	 * @Param file
	 * @return
	 */
	@PostMapping("/registration_c_and_c_pending")
	public ResponseEntity<Map<?, ?>> uploadGSPRINKRegistrationCDPending(@RequestParam("file") MultipartFile file){
		logger.info("GSPRINK Registration C and D Pending : uploading file... ");
		return excelGSPRINGService.saveGSPRINKRegistrationCDPending(file);
	}
	
}
