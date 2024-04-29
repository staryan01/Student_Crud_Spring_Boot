package org.jsp.Students_marks_card.service;

import java.util.List;

import org.jsp.Students_marks_card.dao.Student_dao;
import org.jsp.Students_marks_card.dto.Student;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component // it will create object for the respective classes
public class Student_service
{
	@Autowired
	Student_dao student_dao;
	
	
	public ResponseStructure<Student> save(Student student)
	{
		double percentage =(	student.getEnglish_marks() + student.getScience_marks() + student.getMaths_marks()) / 3.0;
		student.setPercentage(percentage);
		
		if(percentage > 90)
		{
			student.setResult("distinction");
		}
		else
		{
			if(percentage < 90 && percentage > 60)
			{
				student.setResult("first_class");
			}
			else
			{
				student.setResult("Fail");
			}
		}
//		return student; //inside reference variable  it is having the complete information
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setMsg("Data has been saved successfully");
		responseStructure.setStatus_code(HttpStatus.CREATED.value()); //201
		responseStructure.setData(student_dao.saveStudent(student));
		
		
//		Student student2=student_dao.saveStudent(student);
		return responseStructure;
	}
	public ResponseStructure<List<Student>> saveAll(List<Student> students )
	{
		for(Student student: students)
		{
			double percentage =(	student.getEnglish_marks() + student.getScience_marks() + student.getMaths_marks()) / 3.0;
			student.setPercentage(percentage);
			
			if(percentage > 90)
			{
				student.setResult("distinction");
			}
			else
			{
				if(percentage < 90 && percentage > 60)
				{
					student.setResult("first_class");
				}
				else
				{
					student.setResult("Fail");
				}
			}
//			return student; //inside reference variable  it is having the complete information
		
		}
		ResponseStructure<List<Student>> responseStructure= new ResponseStructure<>();
		responseStructure.setMsg("Data of Multiple students has been saved succussfully");
		responseStructure.setStatus_code(HttpStatus.CREATED.value()); //201
		responseStructure.setData(student_dao.saveMultipleStudents(students));
		return responseStructure;
	}
	
	public ResponseStructure<Student> fetchById(int id)
	{
		Student student=student_dao.fetchById(id);
		
		ResponseStructure<Student> responseStructure=new ResponseStructure<>();
		if(student == null)
		{
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(student);
		}
		return responseStructure;
	}
	 
	public ResponseStructure<List<Student>> fetchByMobile(long mobile) 
	{
		
		 
		List<Student> list_of_students =student_dao.fetchByMobile(mobile);
		
		ResponseStructure<List<Student>> responseStructure= new  ResponseStructure<>();
		if(list_of_students.isEmpty())
		{
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(list_of_students);
		}
		return responseStructure;
	}
 
	public ResponseStructure<List<Student>> fetchByResult(String result)
	{
		List<Student> list_of_student=student_dao.fetchByResult(result);
		
		ResponseStructure<List<Student>> responseStructure= new  ResponseStructure<>();
		if(list_of_student.isEmpty())
		{
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(list_of_student);
		}
		return responseStructure;
		
	}
	public ResponseStructure<List<Student>> fetchByNameandResult(String name, double percentage)
	{
		List<Student> list_of_students=student_dao.fetchByNameandResult(name,percentage);
		
		ResponseStructure<List<Student>> responseStructure= new  ResponseStructure<>();
		if(list_of_students.isEmpty())
		{
			responseStructure.setMsg("Data not found");
			responseStructure.setStatus_code(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("Data found");
			responseStructure.setStatus_code(HttpStatus.FOUND.value());
			responseStructure.setData(list_of_students);
		}
		return responseStructure;
		
	}
	public ResponseStructure<Student> edit(Student student)
	{
		double percentage =(student.getEnglish_marks() + student.getScience_marks() + student.getMaths_marks()) / 3.0;
		student.setPercentage(percentage);
		
		if(percentage > 90)
		{
			student.setResult("distinction");
		}
		else
		{
			if(percentage < 90 && percentage > 60)
			{
				student.setResult("first_class");
			}
			else
			{
				student.setResult("Fail");
			}
		}
		Student student2 = student_dao.edit(student);
		ResponseStructure<Student> responseStructure = new ResponseStructure<>();
		responseStructure.setMsg("Data updated successfully");
		responseStructure.setStatus_code(HttpStatus.ACCEPTED.value());
		responseStructure.setData(student2);
		return responseStructure;
	}
	public ResponseStructure<Student> deleteById(int id) {
		{
			student_dao.deleteById(id);
			
			ResponseStructure<Student> responseStructure= new  ResponseStructure<>();
		
				responseStructure.setMsg("Data deleted successfully");
				responseStructure.setStatus_code(HttpStatus.ACCEPTED.value());
				responseStructure.setData(null);
			
				return responseStructure;
			
			
		}
	}
	public ResponseStructure<Student> deleteAll()
	{
		student_dao.deleteAll();
		
		ResponseStructure<Student> responseStructure= new  ResponseStructure<>();
		
		responseStructure.setMsg("Data deleted successfully");
		responseStructure.setStatus_code(HttpStatus.ACCEPTED.value());
		responseStructure.setData(null);
	
		return responseStructure;
	
	}
	
}
