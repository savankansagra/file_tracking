package com.royal.filetracking.uploadexcels.repository.GDRS;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.uploadexcels.model.GDRS.GDRSNewRegistation;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSPendingSupplier;

public interface GDRSPendingSupplierRepository extends JpaRepository<GDRSPendingSupplier, Long> {

}
