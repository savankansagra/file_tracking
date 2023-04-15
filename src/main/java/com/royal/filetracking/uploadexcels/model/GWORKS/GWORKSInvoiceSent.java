package com.royal.filetracking.uploadexcels.model.GWORKS;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_sent")
public class GWORKSInvoiceSent {

	@Id
	@Column(name ="Reg_No")
	private String regNo;
	
	@Column(name ="Reg_Date")
	private Date regDate;

	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "village")
	private String village;
	
	@Column(name = "invoice_sent_date")
	private Date invoiceSentDate;
	
	@Column(name= "twenty_Five_Rel_Dt")
	private String twentyFiveRelDt;
	
	@Column(name = "Farmer_Name")
	private String farmerName;
	
	@Column(name = "MIS_System")
	private String misSystem;
	
	@Column(name = "Loanne_Non_Loanee")
	private String loanneNonLoanee;
	
	@Column(name = "Area_Hec")
	private Double areaHec;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "gps")
	private String gps;
	
	@Column(name = "inspection_date")
	private Date inspectionDate;
	
	@Column(name = "Est_mis_cost")
	private Double estMisCost;
	
	@Column(name = "fp_inward_date")
	private String fpInwardDate;
	
	@Column(name = "invoice_physical_verification_dt")
	private String invoicePhysicalVerificationDate;
	
	@Column(name = "tr_verified_dt")
	private String trVerifiedDt;
	
	/**
	 * Constructor
	 */
	public GWORKSInvoiceSent() {
		super();
	}
	
	/**
	 * Getters and Setters
	 */
	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public Date getInvoiceSentDate() {
		return invoiceSentDate;
	}

	public void setInvoiceSentDate(Date invoiceSentDate) {
		this.invoiceSentDate = invoiceSentDate;
	}

	public String getTwentyFiveRelDt() {
		return twentyFiveRelDt;
	}

	public void setTwentyFiveRelDt(String twentyFiveRelDt) {
		this.twentyFiveRelDt = twentyFiveRelDt;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public Date getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Date inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public Double getEstMisCost() {
		return estMisCost;
	}

	public void setEstMisCost(Double estMisCost) {
		this.estMisCost = estMisCost;
	}

	public String getFpInwardDate() {
		return fpInwardDate;
	}

	public void setFpInwardDate(String fpInwardDate) {
		this.fpInwardDate = fpInwardDate;
	}

	public String getInvoicePhysicalVerificationDate() {
		return invoicePhysicalVerificationDate;
	}

	public void setInvoicePhysicalVerificationDate(String invoicePhysicalVerificationDate) {
		this.invoicePhysicalVerificationDate = invoicePhysicalVerificationDate;
	}

	public String getTrVerifiedDt() {
		return trVerifiedDt;
	}

	public void setTrVerifiedDt(String trVerifiedDt) {
		this.trVerifiedDt = trVerifiedDt;
	}
	
}
