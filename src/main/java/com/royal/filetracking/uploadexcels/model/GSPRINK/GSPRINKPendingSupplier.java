package com.royal.filetracking.uploadexcels.model.GSPRINK;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gsprink_pending_supplier")
public class GSPRINKPendingSupplier {
	
	@Id
	@Column(name="Reg_No")
	private String regNo;
	
	@Column(name="Reg_Date")
	private String regDate;
	
	@Column(name="Appl_Date")
	private Date applDate;
	
	@Column(name="Farmer_Name")
	private String farmerName;
	
	@Column(name="Supplier")
	private String supplier;
	
	@Column(name="MIS_System")
	private String misSystem;
	
	@Column(name="Loanne_Non_Loanee")
	private String loanneNonLoanee;

	@Column(name="Area_Hec")
	private Double areaHec;
	
	@Column(name="back")
	private String back;
	
	@Column(name="rmkback_to_gsprink")
	private String rmkBackToGSprink; 

	/**
	 *  Constructor.
	 */
	public GSPRINKPendingSupplier() {
		super();
	}

	/**
	 *  Getters And Setter
	 */
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Date getApplDate() {
		return applDate;
	}

	public void setApplDate(Date applDate) {
		this.applDate = applDate;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getMisSystem() {
		return misSystem;
	}

	public void setMisSystem(String misSystem) {
		this.misSystem = misSystem;
	}

	public String getLoanneNonLoanee() {
		return loanneNonLoanee;
	}

	public void setLoanneNonLoanee(String loanneNonLoanee) {
		this.loanneNonLoanee = loanneNonLoanee;
	}

	public Double getAreaHec() {
		return areaHec;
	}

	public void setAreaHec(Double areaHec) {
		this.areaHec = areaHec;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getRmkBackToGSprink() {
		return rmkBackToGSprink;
	}

	public void setRmkBackToGSprink(String rmkBackToGSprink) {
		this.rmkBackToGSprink = rmkBackToGSprink;
	}
	
}
