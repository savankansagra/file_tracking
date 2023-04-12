package com.royal.filetracking.uploadexcels.repository.GDRS;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.uploadexcels.model.GDRS.GDRSCandDCleared;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSReceivedForCorrection;

public interface GDRSReceivedForCorrectionRespository extends JpaRepository<GDRSReceivedForCorrection, String> {
	
}
