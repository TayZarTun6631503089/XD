package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
@Entity
public class LastInfo {
	
	public LastInfo() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long student_id;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private StudentBasicInfo studentBasicInfo;

	@Lob
	private String advisorRecommendationLetterBase64;

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
