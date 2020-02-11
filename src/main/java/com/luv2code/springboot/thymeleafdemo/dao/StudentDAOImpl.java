package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.thymeleafdemo.entity.Student;
import com.luv2code.springboot.thymeleafdemo.service.Studentservice;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private Studentservice srudentservice;
	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Student> getStudents() {

		Query theQuery = entityManager.createQuery("from Student");

		// execute query and get result list
		List<Student> students = theQuery.getResultList();

		// return the results
		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {

		Session currentSession = entityManager.unwrap(Session.class);
		// save employee

		currentSession.saveOrUpdate(student);

	}

	@Override
	public Student get(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, theId);

		return student;
	}

	@Override
	@Transactional
	public void delete(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);

		theQuery.executeUpdate();
	}

}
