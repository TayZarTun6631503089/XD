package com.example.demo.dto;

import java.util.List;

import com.example.demo.entity.LastInfo;
import com.example.demo.entity.ScholarshipHistory;


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

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getStudent_age() {
		return student_age;
	}

	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}

	public String getStudent_year() {
		return student_year;
	}

	public void setStudent_year(String student_year) {
		this.student_year = student_year;
	}

	public String getStudent_major() {
		return student_major;
	}

	public void setStudent_major(String student_major) {
		this.student_major = student_major;
	}

	public String getSchoolOf() {
		return schoolOf;
	}

	public void setSchoolOf(String schoolOf) {
		this.schoolOf = schoolOf;
	}

	public double getStudent_gpaX() {
		return student_gpaX;
	}

	public void setStudent_gpaX(double student_gpaX) {
		this.student_gpaX = student_gpaX;
	}

	public String getStudent_phoneNumber() {
		return student_phoneNumber;
	}

	public void setStudent_phoneNumber(String student_phoneNumber) {
		this.student_phoneNumber = student_phoneNumber;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_advisorName() {
		return student_advisorName;
	}

	public void setStudent_advisorName(String student_advisorName) {
		this.student_advisorName = student_advisorName;
	}

	public LastInfo getLastInfo() {
		return lastInfo;
	}

	public void setLastInfo(LastInfo lastInfo) {
		this.lastInfo = lastInfo;
	}

	public List<ScholarshipHistory> getScholarshipHistories() {
		return scholarshipHistories;
	}

	public void setScholarshipHistories(List<ScholarshipHistory> scholarshipHistories) {
		this.scholarshipHistories = scholarshipHistories;
	}
	
	

}
