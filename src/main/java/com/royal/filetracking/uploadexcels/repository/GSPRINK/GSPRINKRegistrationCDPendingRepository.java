package com.royal.filetracking.uploadexcels.repository.GSPRINK;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.filetracking.uploadexcels.model.GDRS.GDRSNewRegistation;
import com.royal.filetracking.uploadexcels.model.GDRS.GDRSPendingSupplier;
import com.royal.filetracking.uploadexcels.model.GSPRINK.GSPRINKPendingSupplier;
import com.royal.filetracking.uploadexcels.model.GSPRINK.GSPRINKRegistrationCDPending;

public interface GSPRINKRegistrationCDPendingRepository extends JpaRepository<GSPRINKRegistrationCDPending, String> {

}
