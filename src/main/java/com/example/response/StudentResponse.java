package com.example.response;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Student;
import com.example.entity.Subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StudentResponse {

	private int id;

	private int addressId;

	private String firstName;

	private String lastName;

	private String email;
	
	private String street;

	private String city;

	private String fullName;

	
	private List<SubjectResponse> learningSubjects;


	public StudentResponse (Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();

		this.addressId = student.getAddress().getId();
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();

		/*if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}*/
	}
}
