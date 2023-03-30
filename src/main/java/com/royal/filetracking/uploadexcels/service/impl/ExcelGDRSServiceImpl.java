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
import com.royal.filetracking.uploadexcels.model.GDRSNewRegistation;
import com.royal.filetracking.uploadexcels.repository.GDRSNewRegistrationRepository;
import com.royal.filetracking.uploadexcels.service.ExcelGDRSService;


@Service
public class ExcelGDRSServiceImpl implements ExcelGDRSService {

	@Autowired
	GDRSNewRegistrationRepository gdrsNewRegistrationRepository;
	
	
	public final Logger logger = LoggerFactory.getLogger(ExcelGDRSServiceImpl.class);
	
	
	/************************************************************************
	 * GDRS New Registration 
	 */
	/**
	 * Check file format and convert excel file to DB Object and save.
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
				List<GDRSNewRegistation> newRegistrationList = this.convertToList(file);
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
	
	
	private List<GDRSNewRegistation> convertToList(MultipartFile file) throws IOException {
		return GDRSNewRegistrationHelper.excelToGDRSNewRegistration(file.getInputStream());
	}


	private List<GDRSNewRegistation> saveGDRSNewRegistrationToDB(List<GDRSNewRegistation> newRegistrationList) {
		return gdrsNewRegistrationRepository.saveAll(newRegistrationList);
	}
	
}