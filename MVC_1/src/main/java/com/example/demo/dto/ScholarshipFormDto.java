package com.example.demo.dto;

public class ScholarshipFormDto {
	
	public ScholarshipFormDto() {}
	
	private LastInfoDto lastInfoDto;
	private ScholarshipHistoryDto scholarshipHistoryDto;
	private StudentBasicInfoDto studentBasicInfoDto;
	public LastInfoDto getLastInfoDto() {
		return lastInfoDto;
	}
	public void setLastInfoDto(LastInfoDto lastInfoDto) {
		this.lastInfoDto = lastInfoDto;
	}
	public ScholarshipHistoryDto getScholarshipHistoryDto() {
		return scholarshipHistoryDto;
	}
	public void setScholarshipHistoryDto(ScholarshipHistoryDto scholarshipHistoryDto) {
		this.scholarshipHistoryDto = scholarshipHistoryDto;
	}
	public StudentBasicInfoDto getStudentBasicInfoDto() {
		return studentBasicInfoDto;
	}
	public void setStudentBasicInfoDto(StudentBasicInfoDto stueBasicInfoDto) {
		this.studentBasicInfoDto = stueBasicInfoDto;
	}
	
	

}
