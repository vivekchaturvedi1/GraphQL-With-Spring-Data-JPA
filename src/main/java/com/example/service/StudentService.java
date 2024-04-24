package com.example.service;

import com.example.entity.Address;
import com.example.entity.Subject;
import com.example.repository.AddressRepository;
import com.example.repository.SubjectRepository;
import com.example.request.CreateStudentRequest;
import com.example.request.CreateSubjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	SubjectRepository subjectRepository;


	public Student getStudentById (int id) {
		logger.info("{}#getStudentById() is called | Input id : {}", this.getClass().getSimpleName(), id);
		Student student = studentRepository.findById(id).get();
		return student;
	}

	public List<Student> getAllStudents () {
		logger.info("{}#getAllStudents() is called !", this.getClass().getSimpleName());
		List<Student> students = studentRepository.findAll();
		return students;
	}

	public Student createStudent (CreateStudentRequest createStudentRequest) {
		logger.info("{}#createStudent() is called | createStudentRequest : {}", this.getClass().getSimpleName(), createStudentRequest);
		Student student = new Student(createStudentRequest);

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		student.setAddress(address);
		student = studentRepository.save(student);

		List<Subject> subjectsList = new ArrayList<>();

		if(createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest :
					createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);

				subjectsList.add(subject);
			}

			subjectRepository.saveAll(subjectsList);
		}

		student.setLearningSubjects(subjectsList);
		return student;
	}
}
