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

import com.royal.filetracking.uploadexcels.service.ExcelGWORKSService;
import com.royal.filetracking.uploadexcels.utils.Constant;

@RestController
@CrossOrigin
@RequestMapping(path = Constant.GWORKS_END_POINT)
public class GWORKSController {
	
	public final Logger logger = LoggerFactory.getLogger(GWORKSController.class);
	
	@Autowired
	ExcelGWORKSService excelGWORKSService;
	
	/**
	 * Work Order Received file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/wo_rcvd")
	public ResponseEntity<Map<?, ?>> uploadGWORKSWorkOrderReceived(@RequestParam("file") MultipartFile file){
		logger.info("GWorks work order received : uploading file...");
		return excelGWORKSService.saveWorkOrderReceived(file);
	}
	
	/**
	 * TPA Sent file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/tpa_sent")
	public ResponseEntity<Map<?, ?>> uploadGWORKSTPASent(@RequestParam("file") MultipartFile file){
		logger.info("GWorks TPA Sent : uploading file...");
		return excelGWORKSService.saveTPASent(file);
	}

	
	/**
	 * TPA Cleared file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/tpa_cleared")
	public ResponseEntity<Map<?, ?>> uploadGWORKSTPACleared(@RequestParam("file") MultipartFile file){
		logger.info("GWorks TPA Cleared : uploading file...");
		return excelGWORKSService.saveTPACleared(file);
	}
	
	/**
	 * Inspection send file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/insp_sent")
	public ResponseEntity<Map<?, ?>> uploadGWORKSInspSent(@RequestParam("file") MultipartFile file){
		logger.info("GWorks Inspection sent : uploading file...");
		return excelGWORKSService.saveInspectionSent(file);
	}
	
	/**
	 * Inspection not installed file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/insp_not_installed")
	public ResponseEntity<Map<?, ?>> uploadGWORKSInspNotInstalled(@RequestParam("file") MultipartFile file){
		logger.info("GWorks Inspection not installed : uploading file...");
		return excelGWORKSService.saveInspNotInstalled(file);
	}
	
	/**
	 * Inspection installed file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/insp_cleared")
	public ResponseEntity<Map<?, ?>> uploadGWORKSInspCleared(@RequestParam("file") MultipartFile file){
		logger.info("GWorks Inspection installed : uploading file...");
		return excelGWORKSService.saveInspCleared(file);
	}
	
	/**
	 * Invoice Sent file upload.
	 * 
	 * @param file
	 * @return
	 */
	@PostMapping("/invoice_sent")
	public ResponseEntity<Map<?, ?>> uploadGWORKSInvoiceSent(@RequestParam("file") MultipartFile file){
		logger.info("GWorks Invoice Sent : uploading file...");
		return excelGWORKSService.saveInvoiceSent(file);
	}
	
	
}
