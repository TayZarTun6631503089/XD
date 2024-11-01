package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.LastInfo;
import com.example.demo.entity.ScholarshipHistory;
import lombok.Data;

@Data
public class StudentBasicInfoDto {
	
	public StudentBasicInfoDto() {}

	private Long student_id;

	private String student_name;
	private int student_age;
	private String student_year;
	private String student_major;
	private String schoolOf;
	private double student_gpaX;
	private String student_phoneNumber;
	private String student_email;
	private String student_advisorName;

	private LastInfo lastInfo;

	private List<ScholarshipHistory> scholarshipHistories;

	

}
