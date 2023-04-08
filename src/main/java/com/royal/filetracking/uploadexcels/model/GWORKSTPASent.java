package com.royal.filetracking.uploadexcels.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tpa_sent")
public class GWORKSTPASent {

	@Id
	@Column(name ="Reg_No")
	private String regNo;
	
	@Column(name ="Reg_Date")
	private Date regDate;
	
	@Column(name = "taluka")
	private String taluka;
	
	@Column(name = "village")
	private String village;
	
	@Column(name = "TPA_Sent_Dt")
	private Date tpaSentDt;
	
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

	@Column(name = "Phy_Verified_Date")
	private String phyVerifiedDate;
	
	@Column(name = "Finance_Verified_Date")
	private String financeVerifiedDate;
	
	@Column(name = "TPA_inward_dt")
	private String tpaInwardDt;
	
	@Column(name = "Instrument_inward_dt")
	private Date instrumentInwardDt;
	
	@Column(name = "TPA")
	private String tpa;

	/**
	 * Constructor
	 */
	public GWORKSTPASent() {
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

	public Date getTpaSentDt() {
		return tpaSentDt;
	}

	public void setTpaSentDt(Date tpaSentDt) {
		this.tpaSentDt = tpaSentDt;
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

	public String getPhyVerifiedDate() {
		return phyVerifiedDate;
	}

	public void setPhyVerifiedDate(String phyVerifiedDate) {
		this.phyVerifiedDate = phyVerifiedDate;
	}

	public String getFinanceVerifiedDate() {
		return financeVerifiedDate;
	}

	public void setFinanceVerifiedDate(String financeVerifiedDate) {
		this.financeVerifiedDate = financeVerifiedDate;
	}

	public String getTpaInwardDt() {
		return tpaInwardDt;
	}

	public void setTpaInwardDt(String tpaInwardDt) {
		this.tpaInwardDt = tpaInwardDt;
	}

	public Date getInstrumentInwardDt() {
		return instrumentInwardDt;
	}

	public void setInstrumentInwardDt(Date instrumentInwardDt) {
		this.instrumentInwardDt = instrumentInwardDt;
	}

	public String getTpa() {
		return tpa;
	}

	public void setTpa(String tpa) {
		this.tpa = tpa;
	}
		
}
