package com.example.demo.service;

import com.example.demo.dto.ScholarshipFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LastInfoDto;
import com.example.demo.dto.ScholarshipHistoryDto;
import com.example.demo.dto.StudentBasicInfoDto;
import com.example.demo.entity.LastInfo;
import com.example.demo.entity.ScholarshipHistory;
import com.example.demo.entity.StudentBasicInfo;
import com.example.demo.repo.LastInfoRepo;
import com.example.demo.repo.ScholarshipHistoryRepo;
import com.example.demo.repo.StudentBasicInfoRepo;

import jakarta.transaction.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Service
public class ScholarshipFormService {
	
	@Autowired
	private StudentBasicInfoRepo studentBasicInfoRepository;

	@Autowired
	private LastInfoRepo lastInfoRepository;

	@Autowired
	private ScholarshipHistoryRepo scholarshipHistoryRepository;
    @Autowired
    private StudentBasicInfoRepo studentBasicInfoRepo;

	@Transactional
	public void saveScholarshipForm(ScholarshipFormDto scholarshipFormDto) {
		StudentBasicInfo studentBasicInfo = studentBasicInfoRepo.findById(scholarshipFormDto.getStudentBasicInfoDto().getStudent_id()).orElseGet(()-> {

			StudentBasicInfo newStudentBasicInfo = new StudentBasicInfo();
	                newStudentBasicInfo.setStudent_id(scholarshipFormDto.getStudentBasicInfoDto().getStudent_id());
	                newStudentBasicInfo.setStudent_name(scholarshipFormDto.getStudentBasicInfoDto().getStudent_name());
					newStudentBasicInfo.setStudent_age(scholarshipFormDto.getStudentBasicInfoDto().getStudent_age());
					newStudentBasicInfo.setStudent_year(scholarshipFormDto.getStudentBasicInfoDto().getStudent_year());
					newStudentBasicInfo.setStudent_major(scholarshipFormDto.getStudentBasicInfoDto().getStudent_major());
					newStudentBasicInfo.setSchoolOf(scholarshipFormDto.getStudentBasicInfoDto().getSchoolOf());
					newStudentBasicInfo.setStudent_gpaX(scholarshipFormDto.getStudentBasicInfoDto().getStudent_gpaX());
					newStudentBasicInfo.setStudent_phoneNumber(scholarshipFormDto.getStudentBasicInfoDto().getStudent_phoneNumber());
					newStudentBasicInfo.setStudent_email(scholarshipFormDto.getStudentBasicInfoDto().getStudent_email());
	                return studentBasicInfoRepository.save(newStudentBasicInfo);

		});

		LastInfo lastInfo = new LastInfo();
	    lastInfo.setStudentBasicInfo(studentBasicInfo); // Set the relationship


		MultipartFile scholarRecommendationFile = scholarshipFormDto.getLastInfoDto().getAdvisorRecommendationLetterBase64();
		lastInfo.setAdvisorRecommendationLetterBase64(FileUtil.convertFileToBase64(scholarRecommendationFile));

		MultipartFile familyIncomeCertifiacation = scholarshipFormDto.getLastInfoDto().getFamilyIncomeCertifiacationBase64();
		lastInfo.setFamilyIncomeCertifiacation(FileUtil.convertFileToBase64(familyIncomeCertifiacation));

		MultipartFile familyStatusCertification = scholarshipFormDto.getLastInfoDto().getFamilyStatusCertificationBase64();
		lastInfo.setFamilyStatusCertification(FileUtil.convertFileToBase64(familyStatusCertification));

		MultipartFile nonParentalGuardianshipCertification = scholarshipFormDto.getLastInfoDto().getNonParentalGuardianshipCertificationBase64();
		lastInfo.setNonParentalGuardianshipCertification(FileUtil.convertFileToBase64(nonParentalGuardianshipCertification));

		MultipartFile signature = scholarshipFormDto.getLastInfoDto().getSignatureBase64();
		lastInfo.setSignature(FileUtil.convertFileToBase64(signature));


	    lastInfo.setTotalFamilyIncome(scholarshipFormDto.getLastInfoDto().getTotalFamilyIncome());
	    lastInfo.setTotalFamilyExpensive(scholarshipFormDto.getLastInfoDto().getTotalFamilyExpensive());
	    lastInfo.setTotalMontylyDebt(scholarshipFormDto.getLastInfoDto().getTotalMontylyDebt());

	    lastInfoRepository.save(lastInfo);

	 // Create and save ScholarshipHistory entity
		ScholarshipHistory scholarshipHistory = new ScholarshipHistory();
		for (ScholarshipHistoryDto scholarshipHistoryDto : scholarshipFormDto.getScholarshipHistoryDtos()) {
			scholarshipHistory.setStudent_id(studentBasicInfo.getStudent_id());
			scholarshipHistory.setScholarBefore(scholarshipHistoryDto.isScholarBefore());
			scholarshipHistory.setScholarName(scholarshipHistoryDto.getScholarName());
			scholarshipHistory.setRecieveYear(scholarshipHistoryDto.getRecieveYear());
			scholarshipHistory.setScholarAmount(scholarshipHistoryDto.getScholarAmount());
			scholarshipHistory.setBasicInfo(studentBasicInfo);
			scholarshipHistory.setHowYouSpendEssay(scholarshipHistoryDto.getHowYouSpendEssay());
			scholarshipHistoryRepository.save(scholarshipHistory);
		}



	}
//
//		lastInfo.setFamilyIncomeCertifiacation(scholarshipFormDto.getLastInfoDto().getFamilyIncomeCertifiacation());
//	    lastInfo.setFamilyStatusCertification(scholarshipFormDto.getLastInfoDto().getFamilyStatusCertification());
//	    lastInfo.setNonParentalGuardianshipCertification(scholarshipFormDto.getLastInfoDto().getNonParentalGuardianshipCertification());
//	    lastInfo.setSignature(scholarshipFormDto.getLastInfoDto().getSignature());
//	@Transactional
//	public void saveScholarshipForm(StudentBasicInfoDto studentBasicInfoDTO, LastInfoDto lastInfoDto,
//			ScholarshipHistoryDto scholarshipHistoryDto) {
//
//
//
//		// Retrieve or create StudentBasicInfo entity
//	    StudentBasicInfo studentBasicInfo = studentBasicInfoRepository.findById(studentBasicInfoDTO.getStudent_id())
//	            .orElseGet(() -> {
//	                StudentBasicInfo newStudentBasicInfo = new StudentBasicInfo();
//	                newStudentBasicInfo.setStudent_id(studentBasicInfoDTO.getStudent_id());
//	                newStudentBasicInfo.setStudent_name(studentBasicInfoDTO.getStudent_name());
//	                // Set other fields from studentBasicInfoDTO...
//	                return studentBasicInfoRepository.save(newStudentBasicInfo);
//	            });
//
//	 // Create and save LastInfo entity
//	    LastInfo lastInfo = new LastInfo();
//	    lastInfo.setStudentBasicInfo(studentBasicInfo); // Set the relationship
//	    lastInfo.setAdvisorRecommendationLetter(lastInfoDto.getAdvisorRecommendationLetter());
//	    lastInfo.setFamilyIncomeCertifiacation(lastInfoDto.getFamilyIncomeCertifiacation());
//	    lastInfo.setFamilyStatusCertification(lastInfoDto.getFamilyStatusCertification());
//	    lastInfo.setNonParentalGuardianshipCertification(lastInfoDto.getNonParentalGuardianshipCertification());
//	    lastInfo.setSignature(lastInfoDto.getSignature());
//	    lastInfo.setTotalFamilyIncome(lastInfoDto.getTotalFamilyIncome());
//	    lastInfo.setTotalFamilyExpensive(lastInfoDto.getTotalFamilyExpensive());
//	    lastInfo.setTotalMontylyDebt(lastInfoDto.getTotalMontylyDebt());
//
//	    lastInfoRepository.save(lastInfo);
//
//	 // Create and save ScholarshipHistory entity
//	    ScholarshipHistory scholarshipHistory = new ScholarshipHistory();
//	    scholarshipHistory.setStudent_id(studentBasicInfo.getStudent_id()); // Set the student_id manually
//	    scholarshipHistory.setBasicInfo(studentBasicInfo); // Set the relationship
//	    scholarshipHistory.setScholarBefore(scholarshipHistoryDto.isScholarBefore());
//	    scholarshipHistory.setScholarName(scholarshipHistoryDto.getScholarName());
//	    scholarshipHistory.setRecieveYear(scholarshipHistoryDto.getRecieveYear());
//	    scholarshipHistory.setScholarAmount(scholarshipHistoryDto.getScholarAmount());
//	    scholarshipHistory.setHowYouSpendEssay(scholarshipHistoryDto.getHowYouSpendEssay());
//
//	    scholarshipHistoryRepository.save(scholarshipHistory);
//
//
//
//
//}
}
