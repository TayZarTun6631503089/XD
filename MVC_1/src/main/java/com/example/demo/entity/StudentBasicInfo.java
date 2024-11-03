package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StudentBasicInfo {

	
	public StudentBasicInfo() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
    @OneToOne(mappedBy = "studentBasicInfo", cascade = CascadeType.ALL)
	private LastInfo lastInfo;

	
	@OneToMany(mappedBy = "basicInfo")
	private List<ScholarshipHistory> scholarshipHistories;


	
}
