package com.royal.filetracking.uploadexcels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.uploadexcels.model.GWORKSWoRcvd;

public interface GWORKSWorkOrderReceivedRepository extends JpaRepository<GWORKSWoRcvd, String> {
	
}
