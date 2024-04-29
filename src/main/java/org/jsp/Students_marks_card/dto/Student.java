package org.jsp.Students_marks_card.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data //when used no need to generate getter and setter. generate getter and setter internally
public class Student
{
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	int sid;
	String sname;
	long mobile;
	
	int maths_marks;
	int science_marks;
	int english_marks;
	double percentage;
	String result;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public int getMaths_marks() {
		return maths_marks;
	}
	public void setMaths_marks(int maths_marks) {
		this.maths_marks = maths_marks;
	}
	public int getScience_marks() {
		return science_marks;
	}
	public void setScience_marks(int science_marks) {
		this.science_marks = science_marks;
	}
	public int getEnglish_marks() {
		return english_marks;
	}
	public void setEnglish_marks(int english_marks) {
		this.english_marks = english_marks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
