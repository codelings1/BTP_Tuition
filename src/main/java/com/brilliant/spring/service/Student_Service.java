package com.brilliant.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brilliant.spring.dao.*;
import com.brilliant.spring.model.*;



@Service
@Transactional
public class Student_Service {
	
	
	
	private Student_Dao student_dao; 
	
	public void setStudentDAO(Student_Dao studentDAO) {
		System.out.println("Service3");
		this.student_dao = studentDAO;
	}

	
	public void addStudent(Student s)
	{ 
		System.out.println("2");
		student_dao.addStudent(s);
	}
	public List<Student> listStudents()
	{
		System.out.println("2");
		return student_dao.listStudents();
		
	}
	public Student getStudent(int id)
	{
//		System.out.println("3");
		return student_dao.getStudent(id);
	}
	public void removeStudent(int id)
	{
		student_dao.removeStudent(id);
	}
	public void editStudent(Student s)
	{
		System.out.println("3");
		student_dao.editStudent(s);
	}
	public List<String> listBatches()
	{
		List<String> listBatches = student_dao.listBatches();
		return listBatches;
	}


	public List<Student> listBatchStudents(String batch) {
		// TODO Auto-generated method stub
		return student_dao.listBatchStudents(batch);
	}
	
}
