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
import com.royal.filetracking.uploadexcels.helper.GWORKSTPAClearedHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKSTPASentHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKSWoRcvdHelper;
import com.royal.filetracking.uploadexcels.model.GWORKSTPACleared;
import com.royal.filetracking.uploadexcels.model.GWORKSTPASent;
import com.royal.filetracking.uploadexcels.model.GWORKSWoRcvd;
import com.royal.filetracking.uploadexcels.repository.GWORKSTPAClearedRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKSTPASentRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKSWorkOrderReceivedRepository;
import com.royal.filetracking.uploadexcels.service.ExcelGWORKSService;

@Service
public class ExcelGWORKSServiceImpl implements ExcelGWORKSService {

	@Autowired
	GWORKSWorkOrderReceivedRepository gworksWorkOrderReceivedRepository;
	
	@Autowired
	GWORKSTPASentRepository gworksTPASentRepository;
	
	@Autowired
	GWORKSTPAClearedRepository gworksTPAClearedRepository;
	
	
	public final Logger logger = LoggerFactory.getLogger(ExcelGWORKSServiceImpl.class);
	
	
	/**
	 * GWORKS Work Order Received
	 * Convert Work Order Received excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveWorkOrderReceived(MultipartFile file) {
		String message = "";
		logger.info("Saving GWORKS work order received file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSWoRcvd> workOrderReceivedList = this.GWORKSWoRcvdConvertToList(file);
				if(workOrderReceivedList.isEmpty()) {
					message="error while parsing the work order received excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSWoRcvd> savedWoRcvdList = this.saveWorkOrderReceivedToDb(workOrderReceivedList);
				if(savedWoRcvdList.isEmpty()) {
					message = "Error while saving the word order received data to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS work order received file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
				
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(resp);
			} 
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
		
	}

	
	private List<GWORKSWoRcvd> GWORKSWoRcvdConvertToList(MultipartFile file) throws IOException {
		return GWORKSWoRcvdHelper.excelToGWORKSWorkOrderReceived(file.getInputStream());
	}
	
	private List<GWORKSWoRcvd> saveWorkOrderReceivedToDb(List<GWORKSWoRcvd> workOrderReceivedList) {
		return gworksWorkOrderReceivedRepository.saveAll(workOrderReceivedList);
	}


	/**
	 * GWORKS TPA Sent
	 * Convert TPA Sent excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveTPASent(MultipartFile file) {
		String message = "";
		logger.info("Saving TPA Send received file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSTPASent> tpaSentList = this.GWORKSTPASentConvertToList(file);
				if(tpaSentList.isEmpty()) {
					message="error while parsing the TPA Sent excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSTPASent> savedTPASentList = this.saveTPASentToDb(tpaSentList);
				if(savedTPASentList.isEmpty()) {
					message = "Error while saving the TPA Sent data to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS TPA Sent file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
				
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(resp);
			} 
		}
		
		// if file format is not excel.
		message = "please upload an excel file!";
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);

	}


	private List<GWORKSTPASent> GWORKSTPASentConvertToList(MultipartFile file) throws IOException {
		return GWORKSTPASentHelper.excelToGWORKSTPASent(file.getInputStream());
	}

	
	private List<GWORKSTPASent> saveTPASentToDb(List<GWORKSTPASent> tpaSentList) {
		return gworksTPASentRepository.saveAll(tpaSentList);
	}


	/**
	 * GWORKS TPA Cleared
	 * Convert TPA Cleared excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveTPACleared(MultipartFile file) {
		String message = "";
		logger.info("Saving TPA Cleared received file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSTPACleared> tpaClearedList = this.GWORKSTPAClearedConvertToList(file);
				if(tpaClearedList.isEmpty()) {
					message="error while parsing the TPA Cleared excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSTPACleared> savedTPAClearedList = this.saveTPAClearedToDb(tpaClearedList);
				if(savedTPAClearedList.isEmpty()) {
					message = "Error while saving the TPA Cleared data to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS TPA Cleared file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
				
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(resp);
			} 
		}
		
		// if file format is not excel.
		message = "please upload an excel file!";
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);

	}

	private List<GWORKSTPACleared> GWORKSTPAClearedConvertToList(MultipartFile file) throws IOException {
		return GWORKSTPAClearedHelper.excelToGWORKSTPACleared(file.getInputStream());
	}
	
	private List<GWORKSTPACleared> saveTPAClearedToDb(List<GWORKSTPACleared> tpaClearedList) {
		return gworksTPAClearedRepository.saveAll(tpaClearedList);
	}
}
