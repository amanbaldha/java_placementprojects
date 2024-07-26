package com.example.PlacementManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacementManagement.entities.College;
import com.example.PlacementManagement.repository.ICollegeRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class ICollegeService 
{
	@Autowired
	private ICollegeRepository collegeRepository;
	
	public List<College> listAll(){
		 return collegeRepository.findAll();
	 }
	 
	 public void save(College college) 
	 {
		 collegeRepository.save(college);
	 }
	 
	 public College get(Integer id) 
	 {
		 return collegeRepository.findById(id).get();
	 }
	 
	 public void delete(Integer id) 
	 {
		 collegeRepository.deleteById(id);
	 }
	
}
