package com.inn.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.inn.model.User;
import com.inn.wrapper.UserWrapper;

public interface UserRest {
	
	
	
	@GetMapping("/getUsers")
	public List<User> getUsers();
	
	@GetMapping("getById/{id}")
	public Optional<User> getById(@PathVariable int id);
	
	@GetMapping("/getByUserName/{userName}")
	public User getByUserName(@PathVariable String userName);
	
	@PutMapping("/updateUser/{id}")
	User updateUser(@PathVariable int id,@RequestBody User user);
	
	@DeleteMapping("/removeUser")
	String deleteUser(int id);

	@PostMapping("/login")
	Map<String, String> login(UserWrapper userWrapper);
	
	@PostMapping("/signUp")
	ResponseEntity<String> signUp(UserWrapper request);

	
}
