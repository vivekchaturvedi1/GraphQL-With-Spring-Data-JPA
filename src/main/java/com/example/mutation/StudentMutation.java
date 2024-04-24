package com.example.mutation;

import com.example.request.CreateStudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMutation implements GraphQLMutationResolver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentService studentService;

    public StudentResponse createStudent (CreateStudentRequest createStudentRequest) {
        logger.info("{}#createStudent() is called  | createStudentRequest data : {}", this.getClass().getSimpleName(), createStudentRequest);
        StudentResponse studentResponse = new StudentResponse(studentService.createStudent(createStudentRequest));
        logger.info("{}#createStudent() is going to exit  | response data : {}", this.getClass().getSimpleName(), studentResponse);
        return  studentResponse;
    }
}
