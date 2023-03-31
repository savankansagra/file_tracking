package com.royal.filetracking.uploadexcels.service.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.uploadexcels.helper.ExcelHelper;
import com.royal.filetracking.uploadexcels.helper.GDRSNewRegistrationHelper;
import com.royal.filetracking.uploadexcels.helper.GDRSPendingRegistrationHelper;
import com.royal.filetracking.uploadexcels.helper.GDRSPendingSupplierHelper;
import com.royal.filetracking.uploadexcels.model.GDRSNewRegistation;
import com.royal.filetracking.uploadexcels.model.GDRSPendingRegistration;
import com.royal.filetracking.uploadexcels.model.GDRSPendingSupplier;
import com.royal.filetracking.uploadexcels.repository.GDRSNewRegistrationRepository;
import com.royal.filetracking.uploadexcels.repository.GDRSPendingRegistrationRepository;
import com.royal.filetracking.uploadexcels.repository.GDRSPendingSupplierRepository;
import com.royal.filetracking.uploadexcels.service.ExcelGDRSService;


@Service
public class ExcelGDRSServiceImpl implements ExcelGDRSService {

	@Autowired
	GDRSNewRegistrationRepository gdrsNewRegistrationRepository;
	
	@Autowired
	GDRSPendingSupplierRepository gdrsPendingSupplierRepository;
	
	@Autowired
	GDRSPendingRegistrationRepository gdrsPendingRegistrationRepository;
		
	public final Logger logger = LoggerFactory.getLogger(ExcelGDRSServiceImpl.class);
	

	/**
	 * GDRS New Registration 
	 * Convert New Registration excel file to DB Object and save.
	 *
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<String> saveGDRSNewRegistration(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS new registration file.");
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSNewRegistation> newRegistrationList = this.GDRSNewRegistrationConvertToList(file);
				if(newRegistrationList.isEmpty()) {
					message = "Error while parsing the new registration excel file.";
					logger.info(message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
				}
				
				// Save list to database.
				List<GDRSNewRegistation> savedRegistration = this.saveGDRSNewRegistrationToDB(newRegistrationList);
				if(savedRegistration.isEmpty()) {
					message = "Error while saving the new registration details to database.";
					logger.info(message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
				}
				message = "GDRS New Registration excel file uploaded succesfully.";
				logger.info(message);
				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
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
	public ResponseEntity<String> saveGDRSPendingSupplier(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS Pending Supplier file.");
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSPendingSupplier> pendingSupplierList = this.GDRSPendingSupplierConvertToList(file);
				if(pendingSupplierList.isEmpty()) {
					message = "Error while parsing the pending supplier excel file";
					logger.info(message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
				}
				
				// Save list to database
				List<GDRSPendingSupplier> savedPendingSupplier = this.saveGDRSPendingSupplierToDB(pendingSupplierList);
				if(savedPendingSupplier.isEmpty()) {
					message = "Error while saving the pending supplier details to database.";
					logger.info(message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
				}
				message = "GDRS Pending Supplier excel file uploaded succesfully.";
				logger.info(message);
				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			} catch (Exception e) {
				message = "Could not process the file.";
				logger.info(message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
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
	public ResponseEntity<String> saveGDRSPendingRegistration(MultipartFile file) {
		String message = "";
		logger.info("Saving GDRS Pending Registration file.");
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get List of object from the file.
				List<GDRSPendingRegistration> pendingRegistrationList = this.GDRSPendingRegistrationToList(file);
				if(pendingRegistrationList.isEmpty()) {
					message = "Error while parsing the pending registration excel file";
					logger.info(message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
				}
				
				// Save list to database.
				List<GDRSPendingRegistration> savedPendingRegistration = this.savedGDRSPendingRegistrationToDB(pendingRegistrationList);
				if(savedPendingRegistration.isEmpty()) {
					message = "Error while saving the pending registration details to database.";
					logger.info(message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
				}
				message = "GDRS Pending Registration excel file uploaded succesfully.";
				logger.info(message);
				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			
			} catch (IOException e) {
				message = "Could not process the file.";
				logger.info(message);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}


	private List<GDRSPendingRegistration> savedGDRSPendingRegistrationToDB(
			List<GDRSPendingRegistration> pendingRegistrationList) {
		return gdrsPendingRegistrationRepository.saveAll(pendingRegistrationList);
	}


	private List<GDRSPendingRegistration> GDRSPendingRegistrationToList(MultipartFile file) throws IOException {
		return GDRSPendingRegistrationHelper.excelToGDRSPendingRegistration(file.getInputStream());
	}
	
}