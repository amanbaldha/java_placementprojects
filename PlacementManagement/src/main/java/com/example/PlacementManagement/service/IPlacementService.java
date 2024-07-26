package com.example.PlacementManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PlacementManagement.entities.Placement;
import com.example.PlacementManagement.repository.IPlacementRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IPlacementService {
	
	@Autowired
	private IPlacementRepository placementRepository;
	
	public List<Placement> listAll(){
		 return placementRepository.findAll();
	 }
	 
	 public void save(Placement placement) 
	 {
		 placementRepository.save(placement);
	 }
	 
	 public Placement get(Integer id) 
	 {
		 return placementRepository.findById(id).orElse(null);
	 }
	 
	 public void delete(Integer id) 
	 {
		 placementRepository.deleteById(id);
	 }
}
