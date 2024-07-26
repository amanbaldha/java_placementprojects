package com.example.PlacementManagement.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.PlacementManagement.entities.Admin;
import com.example.PlacementManagement.repository.IAdminRepository;

//import jakarta.transaction.Transactional;

@Service
@Transactional
public class IAdminService {
	@Autowired
	 private IAdminRepository adminRepository;
	 
	 public List<Admin> listAll(){
		 return adminRepository.findAll();
	 }
	 
	 public void save(Admin admin) 
	 {
		 adminRepository.save(admin);
	 }
	 
	 public Admin get(Integer id) 
	 {
		 return adminRepository.findById(id).get();
	 }
	 
	 public void delete(Integer id) 
	 {
		 adminRepository.deleteById(id);
	 }
}
