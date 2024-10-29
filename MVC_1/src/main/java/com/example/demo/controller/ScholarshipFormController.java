package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.ScholarshipFormDto;

import com.example.demo.service.ScholarshipFormService;

@Controller
@RequestMapping("/")
public class ScholarshipFormController {

    @Autowired
    private ScholarshipFormService scholarshipFormService;

    @GetMapping("/submit-scholarship-form")
    public String showForm(Model model) {
        model.addAttribute("scholarshipFormDto", new ScholarshipFormDto());
        return "scholarship";
    }

    @PostMapping("/submit-scholarship-form-view")
    public String submitForm(@ModelAttribute("scholarshipFormDto") ScholarshipFormDto scholarshipFormDto, Model model) {
        scholarshipFormService.saveScholarshipForm(scholarshipFormDto.getStudentBasicInfoDto(),scholarshipFormDto.getLastInfoDto(),scholarshipFormDto.getScholarshipHistoryDto());
        model.addAttribute("scholarshipFormDto", scholarshipFormDto);
        return "show";
    }
    
    
    
}
