package com.royal.filetracking.uploadexcels.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelGSPRINKService {

	/**
	 * GSPRINK Pending supplier
	 * Convert Pending Supplier excel file to DB Object and save
	 * 
	 * @param file
	 * @return
	 */
	ResponseEntity<Map<?, ?>> saveGDRSPendingSupplier(MultipartFile file);

}
