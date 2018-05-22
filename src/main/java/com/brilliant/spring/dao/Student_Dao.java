package com.brilliant.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.brilliant.spring.model.*;
@Repository
@Transactional
public class Student_Dao {
	
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public void addStudent(Student s)
	{
		System.out.println("3");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(s);
//		System.out.println("4");
	}
	@SuppressWarnings("unchecked")
	public List<Student> listStudents()
	{
		Session session = this.sessionFactory.getCurrentSession();
//		System.out.println("3");
		List<Student> listStudents = session.createQuery("from Student").list();
//		System.out.println("4");
		return listStudents;
	}
	public Student getStudent(int id)
	{
		System.out.println("4");
		Session session = this.sessionFactory.getCurrentSession();
		Student getStudent = (Student) session.load(Student.class, new Integer(id));
		System.out.println(getStudent);
		
//		System.out.println(getStudent.getStud_name() + " " + getStudent.getStud_class());
		System.out.println("5");
		return getStudent;
	}
	public void removeStudent(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Student remStudent = (Student) session.load(Student.class, new Integer(id));
		if(null != remStudent)
		{
			session.delete(remStudent);
		}
	}
	public void editStudent(Student s)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(s);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> listBatches()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<String> listBatches = session.createQuery("select distinct(stud_batch_time) from Student").list();
		return listBatches;
	}

	@SuppressWarnings("unchecked")
	public List<Student> listBatchStudents(String batch) {
		// TODO Auto-generated method stub
//		System.out.println(batch);
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> list_batch_students = session.createQuery("from Student where stud_batch_time like '"+batch+"'").list();
		return list_batch_students;
	}
}
