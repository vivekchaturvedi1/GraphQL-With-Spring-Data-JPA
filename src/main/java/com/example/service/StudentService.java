package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (int id) {
		logger.info("{}#getStudentById() is called  | Input id : {}", this.getClass().getSimpleName(), id);
		Student student = studentRepository.findById(id).get();
		return student;
	}

	public List<Student> getAllStudents () {
		logger.info("{}#getAllStudents() is called !", this.getClass().getSimpleName());
		List<Student> students = studentRepository.findAll();
		return students;
	}
}
