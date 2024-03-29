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
import com.royal.filetracking.uploadexcels.helper.GDRS.GDRSCandDClearedHelper;
import com.royal.filetracking.uploadexcels.helper.GDRS.GDRSCandDSentHelper;
import com.royal.filetracking.uploadexcels.helper.GDRS.GDRSNewRegistrationHelper;
import com.royal.filetracking.uploadexcels.helper.GDRS.GDRSPendingRegistrationHelper;
import com.royal.filetracking.uploadexcels.helper.GDRS.GDRSPendingSupplierHelper;
import com.royal.filetracking.uploadexcels.helper.GDRS.GDRSReceivedForCorrectionHelper;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSCandDCleared;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSCandDSent;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSNewRegistation;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSPendingRegistration;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSPendingSupplier;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSReceivedForCorrection;
import com.royal.filetracking.uploadexcels.repository.GDRS.GDRSCandDClearedRespository;
import com.royal.filetracking.uploadexcels.repository.GDRS.GDRSCandDSentRespository;
import com.royal.filetracking.uploadexcels.repository.GDRS.GDRSNewRegistrationRepository;
import com.royal.filetracking.uploadexcels.repository.GDRS.GDRSPendingRegistrationRepository;
import com.royal.filetracking.uploadexcels.repository.GDRS.GDRSPendingSupplierRepository;
import com.royal.filetracking.uploadexcels.repository.GDRS.GDRSReceivedForCorrectionRespository;
import com.royal.filetracking.uploadexcels.service.ExcelGDRSService;


@Service
public class ExcelGDRSServiceImpl implements ExcelGDRSService {

	@Autowired
	GDRSNewRegistrationRepository gdrsNewRegistrationRepository;
	
	@Autowired
	GDRSPendingSupplierRepository gdrsPendingSupplierRepository;
	
	@Autowired
	GDRSPendingRegistrationRepository gdrsPendingRegistrationRepository;
		
	@Autowired
	GDRSCandDSentRespository gdrsCandDSentRespository;
	
	@Autowired
	GDRSCandDClearedRespository	gdrsCandDClearedRespository;
	
	@Autowired
	GDRSReceivedForCorrectionRespository gdrsReceivedForCorrectionRespository;
	
	
	public final Logger logger = LoggerFactory.getLogger(ExcelGDRSServiceImpl.class);
	

	/**
	 * GDRS New Registration 
	 * Convert New Registration excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGDRSNewRegistration(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS new registration file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSNewRegistation> newRegistrationList = this.GDRSNewRegistrationConvertToList(file);
				if(newRegistrationList.isEmpty()) {
//					message = "Error while parsing the new registration excel file.";
					message = "Please Upload valid \"new registration\" excel file. ";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database.
				List<GDRSNewRegistation> savedRegistration = this.saveGDRSNewRegistrationToDB(newRegistrationList);
				if(savedRegistration.isEmpty()) {
					message = "Error while saving the new registration details to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GDRS New Registration excel file uploaded succesfully.";
				logger.info(message);
				
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
				
			} catch (IOException e) {
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
	
	
	private List<GDRSNewRegistation> GDRSNewRegistrationConvertToList(MultipartFile file) throws IOException {
		return GDRSNewRegistrationHelper.excelToGDRSNewRegistration(file.getInputStream());
	}


	private List<GDRSNewRegistation> saveGDRSNewRegistrationToDB(List<GDRSNewRegistation> newRegistrationList) {
		return gdrsNewRegistrationRepository.saveAll(newRegistrationList);
	}

	
	/**
	 * Pending Supplier 
	 * convert Pending Supplier excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGDRSPendingSupplier(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS Pending Supplier file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSPendingSupplier> pendingSupplierList = this.GDRSPendingSupplierConvertToList(file);
				if(pendingSupplierList.isEmpty()) {
					message = "Error while parsing the pending supplier excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database
				List<GDRSPendingSupplier> savedPendingSupplier = this.saveGDRSPendingSupplierToDB(pendingSupplierList);
				if(savedPendingSupplier.isEmpty()) {
					message = "Error while saving the pending supplier details to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GDRS Pending Supplier excel file uploaded succesfully.";
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


	private List<GDRSPendingSupplier> saveGDRSPendingSupplierToDB(List<GDRSPendingSupplier> pendingSupplierList) {
		return gdrsPendingSupplierRepository.saveAll(pendingSupplierList);
	}


	private List<GDRSPendingSupplier> GDRSPendingSupplierConvertToList(MultipartFile file) throws IOException {
		return GDRSPendingSupplierHelper.excelToGDRSPendingSupplier(file.getInputStream());
	}

	
	/**
	 * Pending Registration
	 * convert Pending Registration excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGDRSPendingRegistration(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS Pending Registration file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSPendingRegistration> pendingRegistrationList = this.GDRSPendingRegistrationToList(file);
				if(pendingRegistrationList.isEmpty()) {
					message = "Error while parsing the pending registration excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database.
				List<GDRSPendingRegistration> savedPendingRegistration = this.savedGDRSPendingRegistrationToDB(pendingRegistrationList);
				if(savedPendingRegistration.isEmpty()) {
					message = "Error while saving the pending registration details to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GDRS Pending Registration excel file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
			
			} catch (IOException e) {
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


	private List<GDRSPendingRegistration> savedGDRSPendingRegistrationToDB(
			List<GDRSPendingRegistration> pendingRegistrationList) {
		return gdrsPendingRegistrationRepository.saveAll(pendingRegistrationList);
	}


	private List<GDRSPendingRegistration> GDRSPendingRegistrationToList(MultipartFile file) throws IOException {
		return GDRSPendingRegistrationHelper.excelToGDRSPendingRegistration(file.getInputStream());
	}

	
	/**
	 * C and D Sent
	 * convert C and D Sent excel file to DB object and save.
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGDRSCandDSent(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS C and D Sent file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSCandDSent> candDSentList = this.GDRSCandDSentToList(file);
				if(candDSentList.isEmpty()) {
					message = "Error while parsing the C and D Sent excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database.
				List<GDRSCandDSent> savedCandDSent = this.savedGDRSCandDSentToDB(candDSentList);
				if(savedCandDSent.isEmpty()) {
					message = "Error while saving the C and D Sent details to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GDRS C and D Sent excel file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
			
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		logger.info(message);
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}


	private List<GDRSCandDSent> savedGDRSCandDSentToDB(List<GDRSCandDSent> candDSentList) {
		return gdrsCandDSentRespository.saveAll(candDSentList);
	}


	private List<GDRSCandDSent> GDRSCandDSentToList(MultipartFile file) throws IOException {
		return GDRSCandDSentHelper.excelToGDRSCandDSent(file.getInputStream());
	}


	/**
	 * C and D Cleared
	 * convert C and D Cleared excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGDRSCandDCleared(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS C and D Cleared file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSCandDCleared> candDClearedList = this.GDRSCandDClearedToList(file);
				if(candDClearedList.isEmpty()) {
					message = "Error while parsing the C and D Cleared excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database.
				List<GDRSCandDCleared> savedCandDCleared = this.savedGDRSCandDClearedToDB(candDClearedList);
				if(savedCandDCleared.isEmpty()) {
					message = "Error while saving the C and D Cleared details to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GDRS C and D Cleared excel file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
			
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		logger.info(message);
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}


	private List<GDRSCandDCleared> savedGDRSCandDClearedToDB(List<GDRSCandDCleared> candDList) {
		return gdrsCandDClearedRespository.saveAll(candDList);
	}


	private List<GDRSCandDCleared> GDRSCandDClearedToList(MultipartFile file) throws IOException {
		return GDRSCandDClearedHelper.excelToGDRSCandDCleared(file.getInputStream());
	}

	
	/**
	 * Received for correction
	 * convert received for correction excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveGDRSReceivedForCorrection(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS Received for correction file.");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSReceivedForCorrection> receivedForCorrectionList = this.GDRSReceivedForCorrectionToList(file);
				if(receivedForCorrectionList.isEmpty()) {
					message = "Error while parsing the Received for correction excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(resp);
				}
				
				// Save list to database.
				List<GDRSReceivedForCorrection> savedRecivedForCorrection = this.savedGDRSReceivedForCorrectionToDB(receivedForCorrectionList);
				if(savedRecivedForCorrection.isEmpty()) {
					message = "Error while saving the received for correction details to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GDRS received for correction excel file uploaded succesfully.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.CREATED).body(resp);
			
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				resp.put("message", message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		logger.info(message);
		resp.put("message", message);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}


	private List<GDRSReceivedForCorrection> savedGDRSReceivedForCorrectionToDB(List<GDRSReceivedForCorrection> candDList) {
		return gdrsReceivedForCorrectionRespository.saveAll(candDList);
	}


	private List<GDRSReceivedForCorrection> GDRSReceivedForCorrectionToList(MultipartFile file) throws IOException {
		return GDRSReceivedForCorrectionHelper.excelToGDRSReceivedForCorrections(file.getInputStream());
	}
	
}