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
import com.example.PlacementManagement.entities.College;
import com.example.PlacementManagement.service.ICollegeService;

@RestController
@RequestMapping("/collegelist")
public class CollegeController {
	@Autowired
	private ICollegeService clg;
	
	@GetMapping
	public List<College> listAll(){
		return clg.listAll();		
	}
	
	@GetMapping("/collegelist/{id}")
	public ResponseEntity<College> get(@PathVariable Integer id){
		try {
			College college=clg.get(id);
			return new ResponseEntity<>(college, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void add(@RequestBody College college) {
		clg.save(college);
	}
	
	@PutMapping("/collegelist/{id}")
	public ResponseEntity<?> update(@RequestBody College college,@PathVariable Integer id){
		try {
			College existAdmin =clg.get(id);
			if(existAdmin !=null) {
				college.setId(id);
				clg.save(college);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/collegelist/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			clg.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
