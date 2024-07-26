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

import com.example.PlacementManagement.entities.Placement;
import com.example.PlacementManagement.service.IPlacementService;

@RestController
@RequestMapping("/placementlist")
public class PlacementController {
	@Autowired
	private IPlacementService place;
	
	@GetMapping
	public List<Placement> listAll(){
		return place.listAll();		
	}
	
	@GetMapping("/Placementlist/{id}")
	public ResponseEntity<Placement> get(@PathVariable Integer id){
		try {
			Placement pls=place.get(id);
			return new ResponseEntity<>(pls, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void add(@RequestBody Placement pls) {
		place.save(pls);
	}
	
	@PutMapping("/placementlist/{id}")
	public ResponseEntity<?> update(@RequestBody Placement pls,@PathVariable Integer id){
		try {
			Placement existAdmin =place.get(id);
			if(existAdmin !=null) {
				pls.setId(id);
				place.save(pls);
				return new ResponseEntity<>(HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/placementlist/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			place.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
