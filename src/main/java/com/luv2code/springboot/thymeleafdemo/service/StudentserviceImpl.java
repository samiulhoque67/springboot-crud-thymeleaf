package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.StudentDAO;
import com.luv2code.springboot.thymeleafdemo.entity.Student;
@Service
public class StudentserviceImpl implements Studentservice {
	@Autowired
	private StudentDAO studentdao;

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentdao.getStudents();
	}

	@Override
	public Student get(int theId) {
		// TODO Auto-generated method stub
		return studentdao.get(theId);
	}

	@Override
	public void saveStudent(Student student) {
		studentdao.saveStudent(student);
		
	}

	@Override
	public void delete(int theId) {
		studentdao.delete(theId);
		
	}
}
