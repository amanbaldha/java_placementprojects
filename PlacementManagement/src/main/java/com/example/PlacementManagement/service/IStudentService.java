package com.example.PlacementManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacementManagement.entities.Student;
import com.example.PlacementManagement.repository.IStudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IStudentService {
	
	@Autowired
	private IStudentRepository studentRepository;
	
	public List<Student> getAllStudents(){
		 return studentRepository.findAll();
	 }
	 
	 public Student addStudent(Student student) 
	 {
		  return studentRepository.save(student);
	 }
	 
	 public Student getStudentById(Integer id) 
	 {
		 return studentRepository.findById(id).orElse(null);
	 }
	 
	 public Student updateStudent(Student student) {
	        return studentRepository.save(student);
	    }
	 
	 public boolean deleteStudent(Integer id) {
	        if (studentRepository.existsById(id)) {
	        	studentRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
}
