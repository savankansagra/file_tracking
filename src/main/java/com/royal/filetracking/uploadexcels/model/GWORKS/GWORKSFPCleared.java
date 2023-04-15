package com.royal.filetracking.uploadexcels.model.GWORKS;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "final_payment_cleared")
public class GWORKSFPCleared {

	@Id
	@Column(name ="Reg_No")
	private String regNo;
	
	@Column(name ="Reg_Date")
	private Date regDate;
	
	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "village")
	private String village;
	
	@Column(name = "FP_date")
	private Date fpDate;
	
	@Column(name= "twenty_Five_Rel_Dt")
	private String twentyFiveRelDt;
	
	@Column(name = "Farmer_Name")
	private String farmerName;
	
	@Column(name = "Inspection_Agency")
	private String inspectionAgency;
	
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
	
	@Column(name = "MisCost_Exclusive")
	private Double misCostExclusive;
	
	@Column(name = "inspectionChrg")
	private Double inspectionChrg;
	
	@Column(name = "final_payment_amount")	
	private Double finalPaymentAmount;
	
	
	/**
	 * Constructor
	 */
	public GWORKSFPCleared() {
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

	public Date getFpDate() {
		return fpDate;
	}

	public void setFpDate(Date fpDate) {
		this.fpDate = fpDate;
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

	public String getInspectionAgency() {
		return inspectionAgency;
	}

	public void setInspectionAgency(String inspectionAgency) {
		this.inspectionAgency = inspectionAgency;
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

	public Double getMisCostExclusive() {
		return misCostExclusive;
	}

	public void setMisCostExclusive(Double misCostExclusive) {
		this.misCostExclusive = misCostExclusive;
	}

	public Double getInspectionChrg() {
		return inspectionChrg;
	}

	public void setInspectionChrg(Double inspectionChrg) {
		this.inspectionChrg = inspectionChrg;
	}

	public Double getFinalPaymentAmount() {
		return finalPaymentAmount;
	}

	public void setFinalPaymentAmount(Double finalPaymentAmount) {
		this.finalPaymentAmount = finalPaymentAmount;
	}

}
