package com.example.demo.dto;

public class LastInfoDto {
	
	public LastInfoDto() {}
	
	private String advisorRecommendationLetter;
	private String familyIncomeCertifiacation;
	private String familyStatusCertification;
	private String nonParentalGuardianshipCertification;
	private String signature;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMontylyDebt;
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
