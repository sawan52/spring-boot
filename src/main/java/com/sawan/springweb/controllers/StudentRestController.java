package com.sawan.springweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sawan.springweb.entities.Student;
import com.sawan.springweb.repos.StudentRepository;

@RestController
public class StudentRestController {

	@Autowired
	StudentRepository repository;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return repository.findAll();
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("id") int id) {
		return repository.findById(id).get();
	}

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student createStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		return repository.save(student);
	}

	@RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

}
