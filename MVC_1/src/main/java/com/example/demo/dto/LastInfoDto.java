package com.example.demo.dto;

import jakarta.persistence.Lob;
import lombok.Data;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.web.multipart.MultipartFile;

@Data
public class LastInfoDto {
	
	public LastInfoDto() {}

	@Lob
	private MultipartFile advisorRecommendationLetterBase64;

	@Lob
	private MultipartFile showAdvisorRecommendationLetterBase64;
	@Lob
	private MultipartFile familyIncomeCertifiacationBase64;
	@Lob
	private MultipartFile familyStatusCertificationBase64;
	@Lob
	private MultipartFile nonParentalGuardianshipCertificationBase64;
	@Lob
	private MultipartFile signatureBase64;

	@Lob
	private String showAdvisorRecommendationLetter;
	@Lob
	private String familyIncomeCertifiacation;
	@Lob
	private String familyStatusCertification;
	@Lob
	private String nonParentalGuardianshipCertification;
	@Lob
	private String signature;
	
	private int totalFamilyIncome;
    private int totalFamilyExpensive;
    private int totalMontylyDebt;


    

}
