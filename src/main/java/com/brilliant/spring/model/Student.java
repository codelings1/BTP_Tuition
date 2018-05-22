package com.brilliant.spring.model;


import javax.persistence.*;

@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String stud_name;
	private String stud_class;
	private String stud_batch_time;
	private String stud_joining;
	private String stud_fee_submitted_upto_month;
	
	
	public String getStud_fee_submitted_upto_month() {
		return stud_fee_submitted_upto_month;
	}
	public void setStud_fee_submitted_upto_month(
			String stud_fee_submitted_upto_month) {
		this.stud_fee_submitted_upto_month = stud_fee_submitted_upto_month;
	}
	public String getStud_batch_time() {
		return stud_batch_time;
	}
	public void setStud_batch_time(String stud_batch_time) {
		this.stud_batch_time = stud_batch_time;
	}
	public String getStud_joining() {
		return stud_joining;
	}
	public void setStud_joining(String stud_joining) {
		this.stud_joining = stud_joining;
	}
	//Constructor
//	public Student()
//	{
//		stud_name = "A";
//		stud_class = "B";
//	}
//	
//	public Student(String s_name, String s_class)
//	{
//		this.stud_name = s_name;
//		this.stud_class = s_class;
//	}
	//Setters and Getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getStud_class() {
		return stud_class;
	}
	public void setStud_class(String stud_class) {
		this.stud_class = stud_class;
	}

}