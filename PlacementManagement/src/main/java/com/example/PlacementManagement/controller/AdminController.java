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

import com.example.PlacementManagement.entities.Admin;
import com.example.PlacementManagement.service.IAdminService;

@RestController
@RequestMapping("/adminlist")
public class AdminController {
	@Autowired
	private IAdminService ads;
	
	@GetMapping
	public List<Admin> listAll(){
		return ads.listAll();		
	}
	
	@GetMapping("/adminlist/{id}")
	public ResponseEntity<Admin> get(@PathVariable Integer id){
		try {
			Admin admin=ads.get(id);
			return new ResponseEntity<>(admin, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void add(@RequestBody Admin admin) {
		ads.save(admin);
	}
	
	@PutMapping("/adminlist/{id}")
	public ResponseEntity<?> update(@RequestBody Admin admin,@PathVariable Integer id){
		try {
			Admin existAdmin =ads.get(id);
			if(existAdmin !=null) {
				admin.setId(id);
				ads.save(admin);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/adminlist/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			ads.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
