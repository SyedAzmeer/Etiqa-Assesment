package com.etiqa.test.rest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.etiqa.test.rest.Models.Student;
import com.etiqa.test.rest.Repo.StudentRepo;
import com.mysql.cj.log.Log;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome!!!!";
	}
	
	@GetMapping(value = "/students")
	public List<Student> getStudents() {
		return studentRepo.findAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public List<Student> getCourseID(@PathVariable int id) {
		return studentRepo.findByCourseId(id);
	}
	
	@PostMapping(value = "/save")
	public String saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "Saved !";
	}
	
	@PutMapping(value = "update/{id}")
	public String updateStudent(@PathVariable long id,@RequestBody Student student) {
		String result = "";
		Student updatedStudent = studentRepo.findById(id).get();
		updatedStudent.setName(student.getName());
		updatedStudent.setAge(student.getAge());
		updatedStudent.setAddress(student.getAddress());
		updatedStudent.setCourseId(student.getCourseId());
		try {
			studentRepo.save(updatedStudent);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		if(student.getName() != null && student.getName() != "") {
			result = student.getName() + "data is updated!";
		}else {
			result = "Updated !";
		}
		 
		return result;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		String result = "";
		Student deleteUser = studentRepo.findById(id).get();
		try {
			studentRepo.delete(deleteUser);
		}catch(Exception e){
			e.printStackTrace();
		}
		result = "Delete student with the ID:"+id;
		
		return result;
	}
	
	

}
