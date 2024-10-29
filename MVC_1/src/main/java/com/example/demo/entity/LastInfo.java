package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class LastInfo {
	
	public LastInfo() {}
	
	@Id
	private Long student_id;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private StudentBasicInfo studentBasicInfo;

	private String advisorRecommendationLetter;
	private String familyIncomeCertifiacation;
	private String familyStatusCertification;
	private String nonParentalGuardianshipCertification;
	private String signature;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMontylyDebt;
    
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public StudentBasicInfo getStudentBasicInfo() {
		return studentBasicInfo;
	}
	public void setStudentBasicInfo(StudentBasicInfo studentBasicInfo) {
		this.studentBasicInfo = studentBasicInfo;
	}
	public String getAdvisorRecommendationLetter() {
		return advisorRecommendationLetter;
	}
	public void setAdvisorRecommendationLetter(String advisorRecommendationLetter) {
		this.advisorRecommendationLetter = advisorRecommendationLetter;
	}
	public String getFamilyIncomeCertifiacation() {
		return familyIncomeCertifiacation;
	}
	public void setFamilyIncomeCertifiacation(String familyIncomeCertifiacation) {
		this.familyIncomeCertifiacation = familyIncomeCertifiacation;
	}
	public String getFamilyStatusCertification() {
		return familyStatusCertification;
	}
	public void setFamilyStatusCertification(String familyStatusCertification) {
		this.familyStatusCertification = familyStatusCertification;
	}
	public String getNonParentalGuardianshipCertification() {
		return nonParentalGuardianshipCertification;
	}
	public void setNonParentalGuardianshipCertification(String nonParentalGuardianshipCertification) {
		this.nonParentalGuardianshipCertification = nonParentalGuardianshipCertification;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public int getTotalFamilyIncome() {
		return totalFamilyIncome;
	}
	public void setTotalFamilyIncome(int totalFamilyIncome) {
		this.totalFamilyIncome = totalFamilyIncome;
	}
	public int getTotalFamilyExpensive() {
		return totalFamilyExpensive;
	}
	public void setTotalFamilyExpensive(int totalFamilyExpensive) {
		this.totalFamilyExpensive = totalFamilyExpensive;
	}
	public int getTotalMontylyDebt() {
		return totalMontylyDebt;
	}
	public void setTotalMontylyDebt(int totalMontylyDebt) {
		this.totalMontylyDebt = totalMontylyDebt;
	}
}
