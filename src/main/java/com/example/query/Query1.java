package com.example.query;

import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import com.example.request.SampleRequest;

@Component
public class Query1 implements GraphQLQueryResolver {

	private static final Logger logger = LoggerFactory.getLogger(Query1.class);

	@Autowired
	StudentService service;

	public String firstQuery () {
		return "First Query";
	}
	
	public String secondQuery () {
		return "Second Query";
	}
	
	public String fullName (SampleRequest sampleRequest) {
		return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
	}

	public StudentResponse getStudentById (int id) {
		logger.info("{}#getStudentById() is called  | Input id : {}", this.getClass().getSimpleName(), id);
		return new StudentResponse(service.getStudentById(id));
	}
}
