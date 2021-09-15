package com.inn.restImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inn.model.User;
import com.inn.rest.UserRest;
import com.inn.service.UserService;
import com.inn.wrapper.UserWrapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@CrossOrigin(origins="*")

@SwaggerDefinition(tags = {
	    @Tag(name = "UserRestImpl", description = "Rest APIs related to user") })
public class UserRestImpl implements UserRest{

	@Autowired
	private UserService uservice;
	
	@Override
	@ApiOperation(value="Shows users",notes="This Api gets all users")
	public List<User> getUsers()
	{
		
		return uservice.showUser();
		
	}
	
	@Override
	@ApiOperation(value="gets user by Id",notes="This Api gets all users by Id's")
	public Optional<User> getById(int id) {
		return uservice.getByID(id);
	}
	
	@Override
	@ApiOperation(value="Shows users by name",notes="This Api gets all users by their names")
	public User getByUserName(String userName) {
		return uservice.getByUserName(userName);		
	}
	
	@Override
	@ApiOperation(value="Deletes users",notes="This Api deletes users by Id's")
	public String deleteUser(int id)
	{
		uservice.deleteUser(id);;
		return "";
		
	}
	

	@Override
	@ApiOperation(value="Upadate users",notes="This Api updates users")
	public User updateUser(int id, User user)
	{
		return uservice.updateUser(id, user);
		
	}
	
	@Override
	@ApiOperation(value="Sign up user",notes="This Api helps user to sign in ")
	public ResponseEntity<String> signUp(@RequestBody(required = true) UserWrapper request) {
		// uservice.saveProduct(request);
		try {
			return uservice.createUser(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	@Override
	@PostMapping("/login")
	@ApiOperation(value="login",notes="This Api logs in")
	public Map<String, String> login(@RequestBody(required = true) UserWrapper userWrapper) {
		try {
			return uservice.login(userWrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}

}
