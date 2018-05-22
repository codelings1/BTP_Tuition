package com.brilliant.spring.dao;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brilliant.spring.model.Attendance;
import com.brilliant.spring.model.Student;
@Repository
@Transactional
public class AttendanceDao {
    protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
    @SuppressWarnings("unchecked")
	public void addAttendance(List<Integer> s, String batch) {
		// TODO Auto-generated method stub
//		System.out.println("AttDao1");
		Date date = new Date();
//		System.out.println("AttDao2");
		Session session = this.sessionFactory.getCurrentSession();
		List<Integer> listBatchStudentsId = session.createQuery("select id from Student where stud_batch_time = '"+ batch + "'").list();
		System.out.println("AttDao3");
		System.out.println(listBatchStudentsId);
		for(int i = 0 ; i < listBatchStudentsId.size() ; i++)
		{
			Attendance att = new Attendance();
			//setAttendancePK();
//			String b = listBatchStudentsId.get(i);
            att.setStud_id(listBatchStudentsId.get(i));
			att.setDate(date);
			att.setStud_batch_time(batch);
			System.out.println(listBatchStudentsId.get(i));
			if(s.contains(listBatchStudentsId.get(i)))
			{
				System.out.println("1");
				att.setStatus("Present");
			}
			else
			{
				System.out.println("2"+listBatchStudentsId.get(i));
				att.setStatus("Absent");
			}
			
			session.save(att);
		}
		System.out.println("AttDao4");
//		for(int i = 0 ; i < s.length ; i++)
//		{
//			Attendance att = new Attendance();
//			//setAttendancePK();
//            att.setStud_id(Integer.parseInt(s[i]));
//			att.setDate(date);
//			att.setStud_batch_time(batch);
//			att.setStatus("Present");
//			session.save(att);
//		    
//		}
//		System.out.println("AttDao5");
		
		//session.createQuery("insert into Attendance values");
		
	}
    
	@SuppressWarnings("unchecked")
	public List<Attendance> viewAttendance(String batchDate) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
//		List<String> idStudents = session.createQuery("select id from Student where stud_batch_time = '"+ batch + "'").list();
//		System.out.println(idStudents);
		List<Attendance> listAttendance = session.createQuery("from Attendance where date = '"+ batchDate + "'").list();
		System.out.println(listAttendance);
		return listAttendance;
	}
	@SuppressWarnings("unchecked")
	public List<Date> listBatchDates(String batch) {
		// TODO Auto-generated method stub
		Session session = this .sessionFactory.getCurrentSession();
		Date d1 = new Date();
		//java.sql.Date date = new java.sql.Date(d1);
		
		List<Date> datesList = session.createQuery("select distinct(date) from Attendance where stud_batch_time = '" + batch + "'").list();
		System.out.println(datesList);
		
		//System.out.println(date);
		return datesList;
	}
}
