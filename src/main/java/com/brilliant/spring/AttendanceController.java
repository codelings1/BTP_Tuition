package com.brilliant.spring;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.jpa.criteria.expression.function.LengthFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.brilliant.spring.model.Attendance;
import com.brilliant.spring.model.Student;
import com.brilliant.spring.service.Attendance_Service;
import com.brilliant.spring.service.Student_Service;

@Controller
public class AttendanceController{
	
	Attendance_Service attendance_service;
	Student_Service student_service;
    
	@Autowired(required=true)
	@Qualifier(value="attendance_service")
	public void setAttendance_service(Attendance_Service attendance_service) {
		this.attendance_service = attendance_service;
	}
	@Autowired(required=true)
	@Qualifier(value="student_service")
	public void setStudent_service(Student_Service student_service) {
		this.student_service = student_service;
	}

//	@RequestMapping(value = "two",method=RequestMethod.GET)
	@RequestMapping("/initiateAttendanceModel/{batch}")
	public String addModel(@PathVariable("batch") String batch , Model model) { 
		System.out.println("Here");
	    model.addAttribute("attendance", new Attendance()); 
	    return "redirect:/batchStudentsAttendance/"+batch;
	    //return "redirect:/attendanceEnter/{batch}";
	    //	    return "index"; 
	}
	@RequestMapping("/batchStudentsAttendance/{batch}")
	public String listStudentAttendance(@PathVariable("batch") String batch , Model model)
	{
		model.addAttribute("batchStudents",student_service.listBatchStudents(batch));
		model.addAttribute("batchName",batch);
//		System.out.println("Hello " + batch);
		return "enterAttendanceView";
	}
	
	@RequestMapping("attendanceEnter/{batch}")
	public String enterAttendance(@PathVariable("batch") String batch , Model model , @RequestParam("attendancePresent") List<Integer> s ) //, HttpServletRequest req , HttpServletResponse resp)
	{
		System.out.println("HelloHAHA");
//	    System.out.println(req.getParameter("attendance213"));
//	    System.out.println(req.getParameter("attendance214"));
		//String[] s = req.getParameterValues("attendancePresent");
	    System.out.println(s);
//	    for(int i = 0 ; i < s.length ; i++ )
//	    {
//	    	System.out.println(s[i]);
//	    }
	    attendance_service.addAttendance(s,batch);
		//model.addAttribute("batchStudents",student_service.listBatchStudents(batch));
		//System.out.println("Hello " + batch);
		return "enterAttendanceView";
	}
	
	@RequestMapping("batchDatesList/{batch}")
	public String listBatchDates(@PathVariable("batch")String batch , Model model)
	{
		model.addAttribute("batchDatesList",attendance_service.listBatchDates(batch));
		return "listDatesForAttendance";
	}
	
	@RequestMapping("/batchDatesList/viewAttendanceSheet/{batchDate}")
	public String attendanceSheetView(@PathVariable("batchDate") String batchDate , Model model )//@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ") Date batchDate , Model model)
	{
		
		System.out.println("Inside viewAttendanceSheet - > 1");
		model.addAttribute("listAttendance",attendance_service.viewAttendance(batchDate));
		System.out.println("Inside viewAttendanceSheet - > 2");
		return "listAttendanceView";
	}
}
