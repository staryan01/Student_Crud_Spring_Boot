package org.jsp.Students_marks_card.controller;

import java.util.List;

import org.jsp.Students_marks_card.dto.Student;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.jsp.Students_marks_card.service.Student_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class Mycontroller 
{
	@Autowired
	Student_service student_service;
	
	@PostMapping("savestudent")
//	@ResponseBody
	public ResponseStructure<Student> save(@RequestBody Student student)
	{
		
		ResponseStructure<Student > responseStructure = student_service.save(student); //inside the refernce variable it is having the complete information
		return responseStructure;
	}
	@PostMapping("students/multiple")
	public ResponseStructure<List<Student>> saveMultipleStudents(@RequestBody List<Student> students)
	{
		ResponseStructure<List<Student>> responseStructure= student_service.saveAll(students);
		return responseStructure;
	}
	
	@GetMapping("fetchstudent/{id}")
	public ResponseStructure<Student> fetchById(@PathVariable ("id")int id)   //@RequestParam :- it will be used to receive the id from postman or dummy frontend
	{
		ResponseStructure<Student> responseStructure=student_service.fetchById(id);
		return responseStructure;
	}
	@GetMapping("savestudent/mobile/{mobile}") //8809796147
	public ResponseStructure<List<Student>> fetchByMobile(@PathVariable ("mobile")long mobile)
	{
		ResponseStructure<List<Student>> list=student_service.fetchByMobile(mobile);
		
		return list;
	}
	
	@GetMapping("savestudent/result/{result}")
	public ResponseStructure<List<Student>> fetchByResult(@PathVariable  ("result") String result )
	{
		ResponseStructure<List<Student>> list_of_students= student_service.fetchByResult(result);
		 return list_of_students; 
	}
	
	@GetMapping("savestudent/{name}/{percentage}")
	public ResponseStructure<List<Student>> fetchByNameandResult(@PathVariable ("name")String name,@PathVariable ("percentage")double percentage) 
	{
		ResponseStructure<List<Student>> responseStructure=student_service.fetchByNameandResult(name,percentage);
		return responseStructure;
	}
	
	@PutMapping("savestudent")
	public ResponseStructure<Student> edit(@RequestBody Student student)
	{
		ResponseStructure<Student>  responseStructure= student_service.edit(student);
		return responseStructure;
	}
	
	@DeleteMapping("deletestudent/{id}")
	public ResponseStructure<Student> name(@PathVariable ("id") int id)
	{
		ResponseStructure<Student>  responseStructure= student_service.deleteById(id);
		return responseStructure;
	}
	
	@DeleteMapping("deletestudents")
	public ResponseStructure<Student> deleteAll()
	{
		ResponseStructure<Student> responseStructure = student_service.deleteAll();
		return responseStructure;
	}
}
