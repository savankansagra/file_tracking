package com.royal.filetracking.uploadexcels.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.uploadexcels.helper.ExcelHelper;
import com.royal.filetracking.uploadexcels.helper.GSPRINK.GSPRINKPendingSupplierHelper;
import com.royal.filetracking.uploadexcels.helper.GSPRINK.GSPRINKRegistrationCDPendingHelper;
import com.royal.filetracking.uploadexcels.model.GSPRINK.GSPRINKPendingSupplier;
import com.royal.filetracking.uploadexcels.model.GSPRINK.GSPRINKRegistrationCDPending;
import com.royal.filetracking.uploadexcels.repository.GSPRINK.GSPRINKPendingSupplierRepository;
import com.royal.filetracking.uploadexcels.repository.GSPRINK.GSPRINKRegistrationCDPendingRepository;
import com.royal.filetracking.uploadexcels.service.ExcelGSPRINKService;

@Service
public class ExcelGSPRINKServiceImpl implements ExcelGSPRINKService{

	public final Logger logger = LoggerFactory.getLogger(ExcelGSPRINKServiceImpl.class);
	
	@Autowired
	GSPRINKPendingSupplierRepository gsprinkPendingSupplierRepository;
	
	@Autowired
	GSPRINKRegistrationCDPendingRepository gsprinkRegistrationCDPendingRepository;
	
	/**
	 * GSPRINK Pending supplier
	 * Convert Pending Supplier excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGSPRINKPendingSupplier(MultipartFile file) {
		String message = "";
		logger.info("Saving GSPRINK Pending Supplier file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GSPRINKPendingSupplier> pendingSupplierList = this.GSPRINKPendingSupplierConvertToList(file);
				if(pendingSupplierList.isEmpty()) {
					message = "Error while parsing the gsprink pending supplier excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database
				List<GSPRINKPendingSupplier> savedPendingSupplier = this.saveGSPRINKPendingSupplierToDB(pendingSupplierList);
				if(savedPendingSupplier.isEmpty()) {
					message = "Error while saving the gsprink pending supplier details to database";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GSPRINK Pending supplier excel file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
			} catch (Exception e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		
	}

	private List<GSPRINKPendingSupplier> saveGSPRINKPendingSupplierToDB(
			List<GSPRINKPendingSupplier> pendingSupplierList) {
		return gsprinkPendingSupplierRepository.saveAll(pendingSupplierList);
		
	}

	private List<GSPRINKPendingSupplier> GSPRINKPendingSupplierConvertToList(MultipartFile file) throws IOException {
		return GSPRINKPendingSupplierHelper.excelToGSPRINKPendingSupplier(file.getInputStream());
	}
	
	
	/**
	 * GSPRINK Registration C and D Pending
	 * Convert Registration C and D Pending excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGSPRINKRegistrationCDPending(MultipartFile file) {
		String message = "";
		logger.info("Saving GSPRINK Registartion C and D Pending file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GSPRINKRegistrationCDPending> registrationCDPendingList = this.GSPRINKRegistrationCDPendingConvertToList(file);
				if(registrationCDPendingList.isEmpty()) {
					message = "Error while parsing the gsprink registration C and D Pending excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// TODO - HERE
				// Save list to database
				List<GSPRINKRegistrationCDPending> savedRegistrationCDPending = this.saveGSPRINKRegistrationCDPendingToDB(registrationCDPendingList);
				if(savedRegistrationCDPending.isEmpty()) {
					message = "Error while saving the GSPRINK Registration C and D Pending details to database";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GSPRINK Registration C and D Pending excel file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
			} catch (Exception e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		
	}

	private List<GSPRINKRegistrationCDPending> saveGSPRINKRegistrationCDPendingToDB(
			List<GSPRINKRegistrationCDPending> pendingSupplierList) {
		return gsprinkRegistrationCDPendingRepository.saveAll(pendingSupplierList);
		
	}

	private List<GSPRINKRegistrationCDPending> GSPRINKRegistrationCDPendingConvertToList(MultipartFile file) throws IOException {
		return GSPRINKRegistrationCDPendingHelper.excelToGSPRINKRegistrationCDPending(file.getInputStream());
	}
	

}
