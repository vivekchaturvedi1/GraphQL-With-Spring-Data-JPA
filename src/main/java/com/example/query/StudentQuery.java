package com.example.query;

import com.example.entity.Student;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import com.example.request.SampleRequest;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentQuery implements GraphQLQueryResolver {

	private static final Logger logger = LoggerFactory.getLogger(StudentQuery.class);

	@Autowired
	StudentService service;

	public String firstQuery () {
		return "First Query";
	}

	public String secondQuery () {
		return "Second Query";
	}
	
	public String fullName (SampleRequest sampleRequest) {
		return sampleRequest.getFirstName() + StringUtils.SPACE + sampleRequest.getLastName();
	}


	public StudentResponse getStudentById (int id) {
		logger.info("{}#getStudentById() is called  | Input id : {}", this.getClass().getSimpleName(), id);
		StudentResponse response = new StudentResponse(service.getStudentById(id));
//		logger.info("{}#getStudentById() is going to exit  |  response : {}", this.getClass().getSimpleName(), response);
		return response;
	}


	public List<StudentResponse> getAllStudents () {
		logger.info("{}#getAllStudents() is called ! ", this.getClass().getSimpleName());
		List<Student> response = service.getAllStudents();
		List<StudentResponse> studentResponseList = new ArrayList<>();
		response.forEach(student-> studentResponseList.add(new StudentResponse(student)));
		logger.info("{}#getAllStudents() is going to exit  |  response : {}", this.getClass().getSimpleName(), studentResponseList);
		return studentResponseList;
	}
}
