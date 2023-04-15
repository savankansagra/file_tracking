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
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSFinalPaymentClearedHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSInspClearedHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSInspNotInstalledHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSInspSentHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSInvoiceSentHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSTPAClearedHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSTPASentHelper;
import com.royal.filetracking.uploadexcels.helper.GWORKS.GWORKSWoRcvdHelper;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSFPCleared;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspClrd;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspNotInstalled;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInspSent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSInvoiceSent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSTPACleared;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSTPASent;
import com.royal.filetracking.uploadexcels.model.GWORKS.GWORKSWoRcvd;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSFinalPaymentClearedRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSInspClrdRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSInspNotInstalledRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSInspSentRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSInvoiceSentRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSTPAClearedRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSTPASentRepository;
import com.royal.filetracking.uploadexcels.repository.GWORKS.GWORKSWorkOrderReceivedRepository;
import com.royal.filetracking.uploadexcels.service.ExcelGWORKSService;

@Service
public class ExcelGWORKSServiceImpl implements ExcelGWORKSService {

	@Autowired
	GWORKSWorkOrderReceivedRepository gworksWorkOrderReceivedRepository;
	
	@Autowired
	GWORKSTPASentRepository gworksTPASentRepository;
	
	@Autowired
	GWORKSTPAClearedRepository gworksTPAClearedRepository;
	
	@Autowired
	GWORKSInspSentRepository gworksInspSentRepository;
	
	@Autowired
	GWORKSInspNotInstalledRepository gworksInspNotInstalledRepository;
	
	@Autowired
	GWORKSInspClrdRepository gworksInspClrdRepository;
	
	@Autowired
	GWORKSInvoiceSentRepository	gworksInvoiceSentRepository;
	
	@Autowired
	GWORKSFinalPaymentClearedRepository	gworksFinalPaymentClearedRepository;
	
	
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

	
	/**
	 * GWORKS Inspection Sent
	 * Convert Inspection sent excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveInspectionSent(MultipartFile file) {
		String message = "";
		logger.info("Saving Inspection Sent file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSInspSent> inspSentList = this.GWORKSInspSentConvertToList(file);
				if(inspSentList.isEmpty()) {
					message="error while parsing the Inspection sent excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSInspSent> savedInspSentList = this.saveInspSentToDb(inspSentList);
				if(savedInspSentList.isEmpty()) {
					message = "Error while saving the Inspection sent to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS Inspection Sent file uploaded succesfully.";
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
	
	private List<GWORKSInspSent> GWORKSInspSentConvertToList(MultipartFile file) throws IOException {
		return GWORKSInspSentHelper.excelToGWORKSInspSent(file.getInputStream());
	}
	
	private List<GWORKSInspSent> saveInspSentToDb(List<GWORKSInspSent> inspSentList) {
		return gworksInspSentRepository.saveAll(inspSentList);
	}


	@Override
	public ResponseEntity<Map<?, ?>> saveInspNotInstalled(MultipartFile file) {
		String message = "";
		logger.info("Saving Inspection Not installed file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSInspNotInstalled> inspNotInstalledList = this.GWORKSInspNotInstalledConvertToList(file);
				if(inspNotInstalledList.isEmpty()) {
					message="error while parsing the Inspection Not Installed excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSInspNotInstalled> savedInspNotInstalledList = this.saveInspNotInstalledToDb(inspNotInstalledList);
				if(savedInspNotInstalledList.isEmpty()) {
					message = "Error while saving the Inspection Not installed to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS Inspection Not Installed file uploaded succesfully.";
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
	
	private List<GWORKSInspNotInstalled> GWORKSInspNotInstalledConvertToList(MultipartFile file) throws IOException {
		return GWORKSInspNotInstalledHelper.excelToGWORKSInspNotInstalled(file.getInputStream());
	}
	
	private List<GWORKSInspNotInstalled> saveInspNotInstalledToDb(List<GWORKSInspNotInstalled> inspNotInstalledList) {
		return gworksInspNotInstalledRepository.saveAll(inspNotInstalledList);
	}


	@Override
	public ResponseEntity<Map<?, ?>> saveInspCleared(MultipartFile file) {
		String message = "";
		logger.info("Saving Inspection Cleared file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSInspClrd> inspClearedList = this.GWORKSInspClearedConvertToList(file);
				if(inspClearedList.isEmpty()) {
					message="error while parsing the Inspection Cleared excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSInspClrd> savedInspClrdList = this.saveInspClearedToDb(inspClearedList);
				if(savedInspClrdList.isEmpty()) {
					message = "Error while saving the Inspection Cleared to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS Inspection Cleared file uploaded succesfully.";
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
	
	private List<GWORKSInspClrd> GWORKSInspClearedConvertToList(MultipartFile file) throws IOException {
		return GWORKSInspClearedHelper.excelToGWORKSInspCleared(file.getInputStream());
	}
	
	private List<GWORKSInspClrd> saveInspClearedToDb(List<GWORKSInspClrd> inspClrdList) {
		return gworksInspClrdRepository.saveAll(inspClrdList);
	}


	/**
	 * GWORKS Invoice sent
	 * Convert Invoice sent excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public ResponseEntity<Map<?, ?>> saveInvoiceSent(MultipartFile file) {
		String message = "";
		logger.info("Saving Invoice Sent file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSInvoiceSent> invoiceSentList = this.GWORKSInvoiceSentConvertToList(file);
				if(invoiceSentList.isEmpty()) {
					message="error while parsing the Invoice Sent excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				List<GWORKSInvoiceSent> savedInvoiceSentList = this.saveInvoiceSentToDb(invoiceSentList);
				if(savedInvoiceSentList.isEmpty()) {
					message = "Error while saving the Invoice Sent to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS Invoice Sent file uploaded succesfully.";
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

	
	private List<GWORKSInvoiceSent> GWORKSInvoiceSentConvertToList(MultipartFile file) throws IOException {
		return GWORKSInvoiceSentHelper.excelToGWORKSInvoiceSent(file.getInputStream());
	}
	
	private List<GWORKSInvoiceSent> saveInvoiceSentToDb(List<GWORKSInvoiceSent> invoiceSentList) {
		return gworksInvoiceSentRepository.saveAll(invoiceSentList);
	}


	@Override
	public ResponseEntity<Map<?, ?>> saveFinalPaymentCleared(MultipartFile file) {
		String message = "";
		logger.info("Saving Final Payment Cleared file");
		Map<String, String> resp = new HashMap<>();
		if(ExcelHelper.hasExcelFormat(file)) {
			try {
				// Get list of object from the file.
				List<GWORKSFPCleared> finalPaymentClearedList = this.GWORKSFinalPaymentClearedConvertToList(file);
				if(finalPaymentClearedList.isEmpty()) {
					message="error while parsing the Final Payment cleared excel file";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
							.body(resp);
				}
				
				// Save list to database
				// TODO - start
				List<GWORKSFPCleared> savedFinalPaymentClearedList = this.saveFinalPaymentClearedToDb(finalPaymentClearedList);
				if(savedFinalPaymentClearedList.isEmpty()) {
					message = "Error while saving the final payment cleared to database.";
					logger.info(message);
					resp.put("message", message);
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
				}
				message = "GWORKS Final Payment Cleared file uploaded succesfully.";
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

	private List<GWORKSFPCleared> GWORKSFinalPaymentClearedConvertToList(MultipartFile file) throws IOException {
		return GWORKSFinalPaymentClearedHelper.excelToGWORKSInspSent(file.getInputStream());
	}
	
	private List<GWORKSFPCleared> saveFinalPaymentClearedToDb(List<GWORKSFPCleared> finalPaymentClearedList) {
		return gworksFinalPaymentClearedRepository.saveAll(finalPaymentClearedList);
	}

}
