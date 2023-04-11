package com.royal.filetracking.uploadexcels.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tpa_cleared")
public class GWORKSTPACleared {

	@Id
	@Column(name ="Reg_No")
	private String regNo;
	
	@Column(name ="Reg_Date")
	private Date regDate;
	
	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "village")
	private String village;
	
	@Column(name= "TPA_Date")
	private Date tpaDate;
	
	@Column(name= "twenty_Five_Rel_Dt")
	private String twentyFiveRelDt;
	
	@Column(name= "Lapse_Days")
	private String lapseDays;
	
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
	
	@Column(name= "AdvPaymentAmt")
	private Double advPaymentAmt;
	
	@Column(name= "Abort_Remarks")
	private String abortRemarks;
	
	@Column(name= "abort_remarks_2")
	private String abortRemarks2;
	
	@Column(name = "Remaining_Days_For_Freeze")
	private String remainingDaysForFreeze;
	
	@Column(name= "TPA_Agency")
	private String tpaAgency;
	
	@Column(name= "System_not_installed_date")
	private String systemNotInstalledDate;
	
	@Column(name = "Est_mis_cost")
	private Double estMisCose;

	@Column(name= "type")
	private String type;
	
	@Column(name= "Days_Lapes_after_Adv_Release_date")
	private String daysLapesAfterAdvReleaseDate;
	
	@Column(name= "TPA")
	private String tpa;
	
	@Column(name = "TPA_inward_dt")
	private String tpaInwardDt;
	
	@Column(name= "approved_tpa_date")
	private Date approvedTpaDate;

	
	/**
	 * Constructor
	 */
	public GWORKSTPACleared() {
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

	public Date getTpaDate() {
		return tpaDate;
	}

	public void setTpaDate(Date tpaDate) {
		this.tpaDate = tpaDate;
	}

	public String getTwentyFiveRelDt() {
		return twentyFiveRelDt;
	}

	public void setTwentyFiveRelDt(String twentyFiveRelDt) {
		this.twentyFiveRelDt = twentyFiveRelDt;
	}

	public String getLapseDays() {
		return lapseDays;
	}

	public void setLapseDays(String lapseDays) {
		this.lapseDays = lapseDays;
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

	public Double getAdvPaymentAmt() {
		return advPaymentAmt;
	}

	public void setAdvPaymentAmt(Double advPaymentAmt) {
		this.advPaymentAmt = advPaymentAmt;
	}

	public String getAbortRemarks() {
		return abortRemarks;
	}

	public void setAbortRemarks(String abortRemarks) {
		this.abortRemarks = abortRemarks;
	}

	public String getAbortRemarks2() {
		return abortRemarks2;
	}

	public void setAbortRemarks2(String abortRemarks2) {
		this.abortRemarks2 = abortRemarks2;
	}

	public String getRemainingDaysForFreeze() {
		return remainingDaysForFreeze;
	}

	public void setRemainingDaysForFreeze(String remainingDaysForFreeze) {
		this.remainingDaysForFreeze = remainingDaysForFreeze;
	}

	public String getTpaAgency() {
		return tpaAgency;
	}

	public void setTpaAgency(String tpaAgency) {
		this.tpaAgency = tpaAgency;
	}

	public String getSystemNotInstalledDate() {
		return systemNotInstalledDate;
	}

	public void setSystemNotInstalledDate(String systemNotInstalledDate) {
		this.systemNotInstalledDate = systemNotInstalledDate;
	}

	public Double getEstMisCose() {
		return estMisCose;
	}

	public void setEstMisCose(Double estMisCose) {
		this.estMisCose = estMisCose;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDaysLapesAfterAdvReleaseDate() {
		return daysLapesAfterAdvReleaseDate;
	}

	public void setDaysLapesAfterAdvReleaseDate(String daysLapesAfterAdvReleaseDate) {
		this.daysLapesAfterAdvReleaseDate = daysLapesAfterAdvReleaseDate;
	}

	public String getTpa() {
		return tpa;
	}

	public void setTpa(String tpa) {
		this.tpa = tpa;
	}

	public String getTpaInwardDt() {
		return tpaInwardDt;
	}

	public void setTpaInwardDt(String tpaInwardDt) {
		this.tpaInwardDt = tpaInwardDt;
	}

	public Date getApprovedTpaDate() {
		return approvedTpaDate;
	}

	public void setApprovedTpaDate(Date approvedTpaDate) {
		this.approvedTpaDate = approvedTpaDate;
	}
	
	
	
	
}
