package com.brilliant.spring;



import java.util.List;
import javax.mail.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.brilliant.spring.service.*;
import com.brilliant.spring.model.*;


@Controller
public class First_View {
	
	
	protected Student_Service student_service;
	
	@Autowired(required=true)
	@Qualifier(value="student_service")
	public void setStudent_Service(Student_Service ss){
		System.out.println("First_View4");
		this.student_service = ss;
	}
	
	
	@RequestMapping(value = "two",method=RequestMethod.GET)
	public String addModel(Model model) { 
//		System.out.println("Here");
	    model.addAttribute("student", new Student()); 
	    return "index";
	    //	    return "index"; 
	}
	
	@RequestMapping(value = "/first")
	public String firstview(@ModelAttribute("student")Student student)//HttpServletRequest req , HttpServletResponse resp ,) Model model)
	{
//		String msg = "";
//		
//		msg += req.getParameter("stud_name");
//		msg += req.getParameter("stud_class");
//		
		//Student s = new Student(req.getParameter("stud_name"), req.getParameter("stud_class"));
//		Student s = new Student("A","B");
//		System.out.println("2");
//		Map<>
		//model.addAttribute("stud_det",s);
		System.out.println("Inside first");
//		System.out.println("Student Info :" + student.getStud_name() + " " + student.getStud_class());
		
		student_service.addStudent(student);
		return "redirect:/two";
//		return "firstview";
//		return new ModelAndView("firstview","msg",new Student(req.getParameter("stud_name"), req.getParameter("stud_class")));
	}
	@RequestMapping(value = "/edit/first")
	public String editfirstview(@ModelAttribute("student")Student student)
	{
		student_service.editStudent(student);
		return "redirect:/two";
//		return "firstview";
	}
	@RequestMapping(value = {"/listStudents", "edit/listStudents"})
	public String listStudents(Model model)
	{
		System.out.println("1");
		model.addAttribute("listStudents",student_service.listStudents());
		
		return "listStudents";
	}
	@RequestMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") int id , Model model)
	{
//		System.out.println("1");
//		student_service.getStudent(id);
		model.addAttribute("student", student_service.getStudent(id));
//		System.out.println("2");
//		return "redirect:/two";
//		return "redirect:/first";
		return "index";
	}
	@RequestMapping("/remove/{id}")
	public String removeStudent(@PathVariable("id") int id)
	{
		student_service.removeStudent(id);
		return "redirect:/listStudents";
	}
	
	@RequestMapping("/listBatches")
	public String listBatches(Model model)
	{
//		System.out.println("1");
//		List listBatches = student_service.listBatches();
		model.addAttribute("listBatches",student_service.listBatches());
//		System.out.println("2");
		return "listBatches";
	}
	@RequestMapping("specificBatch/{batch}")
	public String specificBatch(@PathVariable("batch") String batch , Model model)
	{
//		System.out.println("1");
		model.addAttribute("batchStudents",student_service.listBatchStudents(batch));
//		System.out.println("2");
		return "specificBatch";
	}
	
//	@RequestMapping("/attendanceEnter/{batch}")
//	public String enterAttendance(@PathVariable("batch") String batch , Model model)
//	{
//		model.addAttribute("batchStudents",student_service.listBatchStudents(batch));
//		//System.out.println("Hello " + batch);
//		return "enterAttendanceView";
//	}
//	@RequestMapping("/submitAttendance")
//	public String submitAttendance(Model model)
//	{
//		model.addAttribute("batchStudents",student_service.listBatchStudents(batch));
//		//System.out.println("Hello " + batch);
//		return "enterAttendanceView";
//	}
}

