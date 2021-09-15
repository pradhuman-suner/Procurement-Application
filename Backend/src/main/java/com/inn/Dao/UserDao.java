package com.inn.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.inn.model.User;


public interface UserDao extends JpaRepository<User, Integer> {

//	UserCredentials getUser(@Param("username") String username, @Param("password") String password,
//			@Param("role") String role);
	
	User getUser(@Param("username") String username, @Param("password") String password);

	static List<String> validUser(@Param("username") String username) {
		// TODO Auto-generated method stub
		return null;
	}

	User getByUserName(String userName);
}
