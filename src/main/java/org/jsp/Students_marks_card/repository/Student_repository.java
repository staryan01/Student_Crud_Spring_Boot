package org.jsp.Students_marks_card.repository;

import java.util.List;

import org.jsp.Students_marks_card.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

//this interface will help us to do the crud operation internally
@Component
public interface Student_repository extends JpaRepository<Student, Integer>
{

	List<Student> findByMobile(long mobile);//here by one mobile number i can fetch multiple students details

	List<Student> findByResult(String result);

	@Query("select x from Student x where sname=?1 and percentage>=?2")
	List<Student> findBySnameandPercentage(String name, double percentage);

	
}
