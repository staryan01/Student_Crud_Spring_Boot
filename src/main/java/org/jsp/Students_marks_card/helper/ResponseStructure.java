package org.jsp.Students_marks_card.helper;

import org.jsp.Students_marks_card.dto.Student;

public class ResponseStructure <T>
{
	String  msg;
	int status_code;
	T data; //it will help to store single student information and multiple student information also
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getStatus_code() {
		return status_code;
	}
	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
