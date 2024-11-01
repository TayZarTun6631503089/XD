package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
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


}
