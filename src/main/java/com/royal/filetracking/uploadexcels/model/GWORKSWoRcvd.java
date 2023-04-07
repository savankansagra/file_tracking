package com.royal.filetracking.uploadexcels.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="work_order_received")
public class GWORKSWoRcvd {
	
	@Id
	@Column(name ="Reg_No")
	private String regNo;
	
	@Column(name ="Reg_Date")
	private Date regDate;
	
	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "village")
	private String village;
	
	@Column(name = "WO_Date")
	private Date woDate;
	
	@Column(name = "Lapse_Days")
	private Integer lapseDays;
	
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
	
	@Column(name = "Est_mis_cost")
	private Double estMisCose;
	
	@Column(name = "remaining_days_for_auto_delete")
	private Integer remaingDaysForAutoDelete;
	
	@Column(name = "est_subsidy_amount")
	private Double estimatedSubsidyAmount;
	
	@Column(name = "est_trible_subsidy_amount")
	private Integer estTribleSubsidyAmount;
	
	@Column(name = "TPA_Signed_date")
	private String TPASignedDate;
	
	@Column(name= "TPA_Signed_laps_days")
	private String TPASignedLapsDays;

	/**
	 *  Constructor.
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

	public Date getWoDate() {
		return woDate;
	}

	public void setWoDate(Date woDate) {
		this.woDate = woDate;
	}

	public Integer getLapseDays() {
		return lapseDays;
	}

	public void setLapseDays(Integer lapseDays) {
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

	public Double getEstMisCose() {
		return estMisCose;
	}

	public void setEstMisCose(Double estMisCose) {
		this.estMisCose = estMisCose;
	}

	public Integer getRemaingDaysForAutoDelete() {
		return remaingDaysForAutoDelete;
	}

	public void setRemaingDaysForAutoDelete(Integer remaingDaysForAutoDelete) {
		this.remaingDaysForAutoDelete = remaingDaysForAutoDelete;
	}

	public Double getEstimatedSubsidyAmount() {
		return estimatedSubsidyAmount;
	}

	public void setEstimatedSubsidyAmount(Double estimatedSubsidyAmount) {
		this.estimatedSubsidyAmount = estimatedSubsidyAmount;
	}

	public Integer getEstTribleSubsidyAmount() {
		return estTribleSubsidyAmount;
	}

	public void setEstTribleSubsidyAmount(Integer estTribleSubsidyAmount) {
		this.estTribleSubsidyAmount = estTribleSubsidyAmount;
	}

	public String getTPASignedDate() {
		return TPASignedDate;
	}

	public void setTPASignedDate(String tPASignedDate) {
		TPASignedDate = tPASignedDate;
	}

	public String getTPASignedLapsDays() {
		return TPASignedLapsDays;
	}

	public void setTPASignedLapsDays(String tPASignedLapsDays) {
		TPASignedLapsDays = tPASignedLapsDays;
	}
}
