package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class ScholarshipHistory {
	
	public ScholarshipHistory() {}
	
	@Id
	private Long student_id;

    private boolean scholarBefore;
    private String scholarName;
    private int recieveYear;
    private int scholarAmount;

    @Lob
    private String howYouSpendEssay;
    
    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private StudentBasicInfo basicInfo;

	public Long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public boolean isScholarBefore() {
		return scholarBefore;
	}

	public void setScholarBefore(boolean scholarBefore) {
		this.scholarBefore = scholarBefore;
	}

	public String getScholarName() {
		return scholarName;
	}

	public void setScholarName(String scholarName) {
		this.scholarName = scholarName;
	}

	public int getRecieveYear() {
		return recieveYear;
	}

	public void setRecieveYear(int recieveYear) {
		this.recieveYear = recieveYear;
	}

	public int getScholarAmount() {
		return scholarAmount;
	}

	public void setScholarAmount(int scholarAmount) {
		this.scholarAmount = scholarAmount;
	}

	public String getHowYouSpendEssay() {
		return howYouSpendEssay;
	}

	public void setHowYouSpendEssay(String howYouSpendEssay) {
		this.howYouSpendEssay = howYouSpendEssay;
	}

	public StudentBasicInfo getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(StudentBasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

}
