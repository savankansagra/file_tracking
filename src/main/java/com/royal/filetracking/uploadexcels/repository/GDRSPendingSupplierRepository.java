package com.royal.filetracking.uploadexcels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.uploadexcels.model.GDRSNewRegistation;
import com.royal.filetracking.uploadexcels.model.GDRSPendingSupplier;

public interface GDRSPendingSupplierRepository extends JpaRepository<GDRSPendingSupplier, Long> {

}
