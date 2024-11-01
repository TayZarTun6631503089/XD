package com.example.demo.dto;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ScholarshipHistoryDto {

	
	private Long student_id;

    private boolean scholarBefore;
    private String scholarName;
    private int recieveYear;
    private int scholarAmount;

    @Lob
    private String howYouSpendEssay;



}
