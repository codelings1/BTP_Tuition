package com.brilliant.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brilliant.spring.model.*;

import com.brilliant.spring.dao.AttendanceDao;
@Service
@Transactional
public class Attendance_Service {
    
	private AttendanceDao attendanceDao; 
	
	public void setAttendanceDao(AttendanceDao attendanceDao) {
		this.attendanceDao = attendanceDao;
	}

	public void addAttendance(List<Integer> s, String batch) {
		// TODO Auto-generated method stub
//		System.out.println("AttService");
		attendanceDao.addAttendance(s,batch);
	}

	public List<Attendance> viewAttendance(String batchDate) {
		// TODO Auto-generated method stub
		return attendanceDao.viewAttendance(batchDate);
	}

	public List<Date> listBatchDates(String batch) {
		// TODO Auto-generated method stub
		return attendanceDao.listBatchDates(batch);
	}

    
	
}
