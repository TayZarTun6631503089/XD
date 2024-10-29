package com.example.demo.service;

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

@Service
public class ScholarshipFormService {
	
	@Autowired
	private StudentBasicInfoRepo studentBasicInfoRepository;

	@Autowired
	private LastInfoRepo lastInfoRepository;

	@Autowired
	private ScholarshipHistoryRepo scholarshipHistoryRepository;
	
	@Transactional
	public void saveScholarshipForm(StudentBasicInfoDto studentBasicInfoDTO, LastInfoDto lastInfoDto,
			ScholarshipHistoryDto scholarshipHistoryDto) {

		// Retrieve or create StudentBasicInfo entity
	    StudentBasicInfo studentBasicInfo = studentBasicInfoRepository.findById(studentBasicInfoDTO.getStudent_id())
	            .orElseGet(() -> {
	                StudentBasicInfo newStudentBasicInfo = new StudentBasicInfo();
	                newStudentBasicInfo.setStudent_id(studentBasicInfoDTO.getStudent_id());
	                newStudentBasicInfo.setStudent_name(studentBasicInfoDTO.getStudent_name());
	                // Set other fields from studentBasicInfoDTO...
	                return studentBasicInfoRepository.save(newStudentBasicInfo);
	            });
	    
	 // Create and save LastInfo entity
	    LastInfo lastInfo = new LastInfo();
	    lastInfo.setStudentBasicInfo(studentBasicInfo); // Set the relationship
	    lastInfo.setAdvisorRecommendationLetter(lastInfoDto.getAdvisorRecommendationLetter());
	    lastInfo.setFamilyIncomeCertifiacation(lastInfoDto.getFamilyIncomeCertifiacation());
	    lastInfo.setFamilyStatusCertification(lastInfoDto.getFamilyStatusCertification());
	    lastInfo.setNonParentalGuardianshipCertification(lastInfoDto.getNonParentalGuardianshipCertification());
	    lastInfo.setSignature(lastInfoDto.getSignature());
	    lastInfo.setTotalFamilyIncome(lastInfoDto.getTotalFamilyIncome());
	    lastInfo.setTotalFamilyExpensive(lastInfoDto.getTotalFamilyExpensive());
	    lastInfo.setTotalMontylyDebt(lastInfoDto.getTotalMontylyDebt());
	    
	    lastInfoRepository.save(lastInfo);
	    
	 // Create and save ScholarshipHistory entity
	    ScholarshipHistory scholarshipHistory = new ScholarshipHistory();
	    scholarshipHistory.setStudent_id(studentBasicInfo.getStudent_id()); // Set the student_id manually
	    scholarshipHistory.setBasicInfo(studentBasicInfo); // Set the relationship
	    scholarshipHistory.setScholarBefore(scholarshipHistoryDto.isScholarBefore());
	    scholarshipHistory.setScholarName(scholarshipHistoryDto.getScholarName());
	    scholarshipHistory.setRecieveYear(scholarshipHistoryDto.getRecieveYear());
	    scholarshipHistory.setScholarAmount(scholarshipHistoryDto.getScholarAmount());
	    scholarshipHistory.setHowYouSpendEssay(scholarshipHistoryDto.getHowYouSpendEssay());

	    scholarshipHistoryRepository.save(scholarshipHistory);
	    
	    


}
}
