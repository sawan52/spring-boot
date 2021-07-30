package com.sawan.springboot.thymeleaf.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sawan.springboot.thymeleaf.model.Student;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message", "Focus on your target and be consistent");
		return mav;
	}

	@RequestMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("Shivam");
		student.setScore(94);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/studentList")
	public ModelAndView getStudentList() {
		ModelAndView mav = new ModelAndView("studentList");

		Student student = new Student();
		student.setName("Shivam");
		student.setScore(94);

		Student student2 = new Student();
		student2.setName("Pradum");
		student2.setScore(88);

		List<Student> studentList = Arrays.asList(student, student2);

		mav.addObject("studentList", studentList);
		return mav;
	}

	@RequestMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student student = new Student();
		student.setName("Shivam");
		student.setScore(94);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student.getName());
		System.out.println(student.getScore());
		return mav;
	}

}
