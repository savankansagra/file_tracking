package com.royal.filetracking.tryTwo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.royal.filetracking.tryTwo.helper.ExcelHelper;
import com.royal.filetracking.tryTwo.model.GDRSNewRegistation;
import com.royal.filetracking.tryTwo.repository.GDRSNewRegistrationRepository;

@Service
public class ExcelGDRSService {
	
	@Autowired
	GDRSNewRegistrationRepository gdrsNewRegistrationRepository;
	
	public final Logger logger = LoggerFactory.getLogger(ExcelGDRSService.class);
	
	/**
	 * Check file format and convert excel file to DB Object and save.
	 * 
	 * @param file
	 * @return
	 * response status with message.
	 */
	public ResponseEntity<String> saveGDRSNewRegistration(MultipartFile file) {
		String message = "";
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// TODO Save file
				this.saveGDRSNewRegistrationToDB(file);
				message = "file uploaded succesfully.";
				return ResponseEntity.status(HttpStatus.CREATED).body(message);
			} catch (Exception e) {
				message = "Could not upload the file.";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
			}
		}
		
		// if file format is not excel.
		message = "please upload an excel file !";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
	}

	/**
	 * Convert Excel to DBObject and Save.
	 * 
	 * @param file
	 */
	private void saveGDRSNewRegistrationToDB(MultipartFile file) {
		try {
			List<GDRSNewRegistation> gdrsNewRegistrations = ExcelHelper.excelToGDRSNewRegistration(file.getInputStream());
			gdrsNewRegistrationRepository.saveAll(gdrsNewRegistrations);
		} catch (Exception e) {
			logger.error("Error while converting GDRS New Registration excel file to database object.");
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	

}
