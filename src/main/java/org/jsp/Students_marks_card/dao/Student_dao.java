package org.jsp.Students_marks_card.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Students_marks_card.dto.Student;
import org.jsp.Students_marks_card.repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Component
public class Student_dao 
{
	@Autowired
	Student_repository student_repository;
	
	public Student saveStudent(Student student)
	{
		Student student2=student_repository.save(student);// save is a inbuilt method which 
		return student2;
	}
	
	public List<Student> saveMultipleStudents(List<Student> students)
	{
		List<Student> list2=(List<Student>) student_repository.saveAll(students);//inbuilt methods
		return list2;
	}
	
	public Student fetchById(int id)
	{
		Optional<Student> optional=student_repository.findById(id);
		if(optional.isEmpty())
		{
			return null;
		}
		else
		{
			Student student = optional.get();
			return student;
		}
	}
	
	public List<Student> fetchByMobile(long mobile)
	{
		List<Student> list_of_students = student_repository.findByMobile(mobile);
		return list_of_students;
	}
	
	public List<Student> fetchByResult(String result)
	{
		List<Student> list_of_students	=student_repository.findByResult(result);
		return list_of_students;
	}
	
	

	public List<Student> fetchByNameandResult(String name, double percentage) 
	{
		List<Student>	list_of_students =student_repository.findBySnameandPercentage(name,percentage);
		return list_of_students;
		
	}

	public Student edit(Student student) 
	{
		Student student2 = student_repository.save(student); //for editing purpose alos i should use save method only in spring boot
		return student2;
		
	}

	public void deleteById(int id) 
	{
		student_repository.deleteById(id); //it is an inbuit method
		
	}

	public void deleteAll()
	{
		student_repository.deleteAll();
	}
	
	
}
