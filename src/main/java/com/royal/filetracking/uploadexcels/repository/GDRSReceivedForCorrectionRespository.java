package com.royal.filetracking.uploadexcels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.uploadexcels.model.GDRSCandDCleared;
import com.royal.filetracking.uploadexcels.model.GDRSReceivedForCorrection;

public interface GDRSReceivedForCorrectionRespository extends JpaRepository<GDRSReceivedForCorrection, String> {
	
}
