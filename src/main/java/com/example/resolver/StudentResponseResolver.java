package com.example.resolver;

import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.enums.SubjectNameFilter;
import com.example.repository.StudentRepository;
import com.example.request.SampleRequest;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    /*public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse){
        logger.info("{}#getLearningSubjects() is called !", this.getClass().getSimpleName());
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        int studentId = studentResponse.getId();
        Student student = studentRepository.findById(studentId).get();
        if (student.getLearningSubjects() != null) {
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}
        // logger.info("{}#getLearningSubjects() is going to exit | learningSubjects : {}", this.getClass().getSimpleName(), learningSubjects);
        return learningSubjects;
    }*/

    // Adding GraphQL Edge Filter (SubjectNameFilter)
    public List<SubjectResponse> getLearningSubjects (StudentResponse studentResponse, SubjectNameFilter subjectNameFilter){
        logger.info("{}#getLearningSubjects() is called !", this.getClass().getSimpleName());
        List<SubjectResponse> learningSubjects = new ArrayList<>();
        int studentId = studentResponse.getId();
        Student student = studentRepository.findById(studentId).get();
        if (student.getLearningSubjects() != null) {
            for (Subject subject: student.getLearningSubjects()) {
                if( subjectNameFilter.name().equalsIgnoreCase(SubjectNameFilter.AllSubjects.name())|| subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }
        logger.info("{}#getLearningSubjects() is going to exit | learningSubjects : {}", this.getClass().getSimpleName(), learningSubjects);
        return learningSubjects;
    }


    public String getFullName (StudentResponse studentResponse) {
        logger.info("{}#fullName() is called !", this.getClass().getSimpleName());
        String fullNameResponse = studentResponse.getFirstName() + StringUtils.SPACE + studentResponse.getLastName();
        logger.info("{}#fullName() is going to exit | fullName : {}", this.getClass().getSimpleName(), fullNameResponse);
        return fullNameResponse;
    }
}
