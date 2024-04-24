package com.example.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateSubjectRequest {

	private String subjectName;
	
	private Double marksObtained;
}
