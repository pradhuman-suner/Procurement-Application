package com.inn.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.inn.model.User;
import com.inn.wrapper.UserWrapper;


public interface UserService {

	ResponseEntity<String> createUser(UserWrapper request);

	Map<String, String> login(UserWrapper userWrapper);

	List<User> showUser();

	Optional<User> getByID(int id);

	User getByUserName(String userName);

	void deleteUser(int id);

	User updateUser(int id, User user);


	// ResponseEntity<String> userSignUp(UserCredentialsWrapper request);
}
