package com.example.PlacementManagement.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PlacementManagement.entities.User;
import com.example.PlacementManagement.repository.IUserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	public List<User> getAllUsers(){
		 return userRepository.findAll();
	 }
	 
	 public User addUser(User user) 
	 {
		 return userRepository.save(user);
	 }
	 
	 public User getUserById(Integer id) 
	 {
		 return userRepository.findById(id).orElse(null);
	 }
	 
	 public User updateUser(User user) {
	        if (userRepository.existsById(user.getId())) {
	            return userRepository.save(user);
	        }
	        throw new NoSuchElementException("User not found for update");
	    }
	 
	 public boolean deleteUser(Integer id) 
	 {
		 if(userRepository.existsById(id)) {
			 userRepository.deleteById(id);
			 return true;
		 }
		 return false;
	 }
	 
//	public User addUser(User user);
//	public User updateUser(User user);
//	public User login(User user);
//	public boolean logOut();
}
