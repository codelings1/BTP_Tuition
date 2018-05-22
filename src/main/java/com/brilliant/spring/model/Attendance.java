package com.brilliant.spring.model;

import java.util.Date;


import javax.persistence.*;

@Entity
@Table
public class Attendance {
	@Id
	private int stud_id;
    private Date date;
    private String stud_batch_time;
    private String status;
	
	public int getStud_id() {
		return stud_id;
	}
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStud_batch_time() {
		return stud_batch_time;
	}
	public void setStud_batch_time(String stud_batch_time) {
		this.stud_batch_time = stud_batch_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}