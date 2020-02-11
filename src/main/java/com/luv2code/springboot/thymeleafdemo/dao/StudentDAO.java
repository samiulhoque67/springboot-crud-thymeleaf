package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Student;

	public interface StudentDAO {
		public  void saveStudent(Student student); 
		public List<Student> getStudents() ;
		public Student get(int theId);
		
		public void delete(int theId);
		
			
		
}
	
