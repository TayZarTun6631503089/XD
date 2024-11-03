package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ScholarshipHistory {
	
	public ScholarshipHistory() {}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
