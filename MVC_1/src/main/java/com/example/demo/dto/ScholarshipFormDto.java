package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ScholarshipFormDto {

	private LastInfoDto lastInfoDto;
	private List<ScholarshipHistoryDto> scholarshipHistoryDtos;
	private StudentBasicInfoDto studentBasicInfoDto;

	

}
