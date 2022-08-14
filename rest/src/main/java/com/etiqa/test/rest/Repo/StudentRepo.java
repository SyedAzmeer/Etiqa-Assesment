package com.etiqa.test.rest.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.etiqa.test.rest.Models.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
	
	@Query(
			  value = "SELECT * FROM student s WHERE s.course_id = :courseId", 
			  nativeQuery = true)
    List<Student> findByCourseId(@Param("courseId") int courseId);
	

}
