package com.example.demo.controller;

import com.example.demo.dto.ScholarshipHistoryDto;
import com.example.demo.service.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ScholarshipFormDto;

import com.example.demo.service.ScholarshipFormService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

@Controller
@RequestMapping("/api")
public class ScholarshipFormController {


    @Autowired
    private ScholarshipFormService scholarshipFormService;

    @GetMapping("/submit-scholarship-form")
    public String showForm(Model model) {

        ScholarshipFormDto scholarshipFormDto = new ScholarshipFormDto();
        scholarshipFormDto.setScholarshipHistoryDtos(new ArrayList<>());
        scholarshipFormDto.getScholarshipHistoryDtos().add(new ScholarshipHistoryDto()); // Add at least one history to display the form
        model.addAttribute("scholarshipFormDto", scholarshipFormDto);

        return "scholarship";
    }

    @PostMapping("/submit-scholarship-form-view")
    public String submitForm(@ModelAttribute("scholarshipFormDto") ScholarshipFormDto scholarshipFormDto, BindingResult bindingResult , Model model) {

        if (bindingResult.hasErrors()) {
            // Return to form with errors displayed
            return "scholarship";
        }


        MultipartFile scholarRecommendationFile = scholarshipFormDto.getLastInfoDto().getAdvisorRecommendationLetterBase64();
        scholarshipFormDto.getLastInfoDto().setShowAdvisorRecommendationLetter(FileUtil.convertFileToBase64(scholarRecommendationFile));

        MultipartFile familyIncomeCertifiacation = scholarshipFormDto.getLastInfoDto().getFamilyIncomeCertifiacationBase64();
        scholarshipFormDto.getLastInfoDto().setFamilyIncomeCertifiacation(FileUtil.convertFileToBase64(familyIncomeCertifiacation));

        MultipartFile familyStatusCertification = scholarshipFormDto.getLastInfoDto().getFamilyStatusCertificationBase64();
        scholarshipFormDto.getLastInfoDto().setFamilyStatusCertification(FileUtil.convertFileToBase64(familyStatusCertification));

        MultipartFile nonParentalGuardianshipCertification = scholarshipFormDto.getLastInfoDto().getNonParentalGuardianshipCertificationBase64();
        scholarshipFormDto.getLastInfoDto().setNonParentalGuardianshipCertification(FileUtil.convertFileToBase64(nonParentalGuardianshipCertification));

        MultipartFile signature = scholarshipFormDto.getLastInfoDto().getSignatureBase64();
        scholarshipFormDto.getLastInfoDto().setSignature(FileUtil.convertFileToBase64(signature));


        scholarshipFormService.saveScholarshipForm(scholarshipFormDto);
        model.addAttribute("scholarshipFormDto", scholarshipFormDto);
        return "show";
    }
}
