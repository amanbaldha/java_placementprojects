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
import com.example.PlacementManagement.entities.User;
import com.example.PlacementManagement.service.IUserService;

@RestController
@RequestMapping("/userlist")
public class UserController {
	@Autowired
	private IUserService userService;
	private User user;
	
	@GetMapping
	public List<User> listAll(){
		return userService.getAllUsers();		
	}
	
	@GetMapping("/userlist/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id){
		try {
			User users=userService.getUserById(id);
			return new ResponseEntity<>(users, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
        User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }
	
	@PutMapping("/userlist/{id}")
	public ResponseEntity<User> update(@RequestBody User users,@PathVariable Integer id){
		try {
			user.setId(id); // Ensure the updated user has the same id
            User updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/userlist/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		try {
			userService.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
