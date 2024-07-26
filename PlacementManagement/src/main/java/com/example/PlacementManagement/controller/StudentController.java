package com.example.PlacementManagement.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.PlacementManagement.entities.Student;
import com.example.PlacementManagement.service.IStudentService;

@RestController
@RequestMapping("/studentlist")
public class StudentController {
	@Autowired
	private IStudentService stud;
	
	@GetMapping
	public List<Student> listAll(){
		return stud.getAllStudents();		
	}
	
	@GetMapping("/studentlist/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		try {
			Student student=stud.getStudentById(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	 public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = stud.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

	@PutMapping("/studentlist/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student,@PathVariable Integer id){
			student.setId(id);
	        Student updatedStudent = stud.updateStudent(student);
	        if (updatedStudent != null) {
	            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/studentlist/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		if (stud.deleteStudent(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
