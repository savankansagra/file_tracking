package com.royal.filetracking.tryTwo.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gdrs_new_registration")
public class GDRSNewRegistation {
	
	@Id
	@Column(name="Reg_No")
	private Long regNo;
	
	@Column(name="Reg_Date")
	private Integer regDate;
	
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
	
	@Column(name="Lastscan")
	private String lastScan;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="DISTRICTID")
	private Integer districtId;
	
	@Column(name="TALUKA")
	private String taluka;
	
	@Column(name="TALUKAID")
	private Integer talukaId;
	
	@Column(name="VILLAGE")
	private String village;
	
	@Column(name="SCHEMEDESC")
	private String schemeDesc;
	
	@Column(name="GUVNLSCHEMEID")
	private Integer guvnlSchemeId;
	
	@Column(name="SURVEYNO")
	private String surveyNo;
	
	@Column(name="MISAREA1")
	private Double misArea1;
	
	@Column(name="SURVEYNO1")
	private String surveyNo1;
	
	@Column(name="back")
	private String back;
	
	@Column(name="FarmerContactNo")
	private Long farmerContactNo;
	
	@Column(name="Borewell")
	private String borewell;


	/**
	 *  Constructor.
	 */
	public GDRSNewRegistation() {
		super();
	}

	/**
	 *  Getters And Setter
	 */
	public long getRegNo() {
		return regNo;
	}


	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}


	public Integer getRegDate() {
		return regDate;
	}


	public void setRegDate(Integer regDate) {
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


	public String getLastScan() {
		return lastScan;
	}


	public void setLastScan(String lastScan) {
		this.lastScan = lastScan;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public Integer getDistrictId() {
		return districtId;
	}


	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}


	public String getTaluka() {
		return taluka;
	}


	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}


	public Integer getTalukaId() {
		return talukaId;
	}


	public void setTalukaId(Integer talukaId) {
		this.talukaId = talukaId;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	public String getSchemeDesc() {
		return schemeDesc;
	}


	public void setSchemeDesc(String schemeDesc) {
		this.schemeDesc = schemeDesc;
	}


	public Integer getGuvnlSchemeId() {
		return guvnlSchemeId;
	}


	public void setGuvnlSchemeId(Integer guvnlSchemeId) {
		this.guvnlSchemeId = guvnlSchemeId;
	}


	public String getSurveyNo() {
		return surveyNo;
	}


	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}


	public Double getMisArea1() {
		return misArea1;
	}


	public void setMisArea1(Double misArea1) {
		this.misArea1 = misArea1;
	}


	public String getSurveyNo1() {
		return surveyNo1;
	}


	public void setSurveyNo1(String surveyNo1) {
		this.surveyNo1 = surveyNo1;
	}


	public String getBack() {
		return back;
	}


	public void setBack(String back) {
		this.back = back;
	}


	public Long getFarmerContactNo() {
		return farmerContactNo;
	}


	public void setFarmerContactNo(Long farmerContactNo) {
		this.farmerContactNo = farmerContactNo;
	}


	public String getBorewell() {
		return borewell;
	}


	public void setBorewell(String borewell) {
		this.borewell = borewell;
	}
	
	
}
