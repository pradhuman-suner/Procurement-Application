package com.inn.serviceImpl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.inn.Dao.UserDao;
import com.inn.model.User;
import com.inn.service.UserService;
import com.inn.wrapper.UserWrapper;



@Service
public class UserServiceImpl implements UserService {
	private Logger logger = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;

	//@Autowired
	//private VendorDao vendorDao;



	@Override
	public ResponseEntity<String> createUser(UserWrapper request) {
		// TODO Auto-generated method stub
		try {
			if (validateUser(request)) {
				if (validateUsername(request.getUserName())) {
					if (request.getRole().equalsIgnoreCase("Admin")) {
						return adminSignUp(request);
					} else if (request.getRole().equalsIgnoreCase("User")) {
						return userSignUp(request);
					}
				} else {
					return new ResponseEntity<>("{\"message\":\"" + "Username  Exists" + "\"}",
							HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>("{\"message\":\"" + "Un sufficient data to create account" + "\"}"+request,
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	private boolean validateUser(UserWrapper request) {
		logger.info("----////////////InSide ValiDateUser line no 66/////////////{} ", request.getUserName().toString());
		if (!Strings.isEmpty(request.getUserName()) && !Strings.isEmpty(request.getPassword())
				&& !Strings.isEmpty(request.getRole())) {
			logger.info("----////////////InSide ValiDateUser line no 69/////////////{} ", request.getRole());
			if (request.getRole().equalsIgnoreCase("Admin")) {
				return true;
			} else if (!Strings.isEmpty(request.getAddress()) && !Strings.isEmpty(request.getContactNo())) {
				logger.info("----////////////InSide ValiDateUser line no 69/////////////{} ", request.getContactNo());
				return true;
			} else {
				return false;
			} 
		} else {
			return false;
		}
	}
	private boolean validateUsername(String username) {
		List<String> list = new ArrayList<String>();
		try {
			list.addAll(UserDao.validUser(username));
			System.out.println(UserDao.validUser(username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	private String getMd5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Map<String, String> login(UserWrapper userWrapper) {
		try {
			logger.info("Inside login {}", userWrapper);
			String username = userWrapper.getUserName();
			String password = userWrapper.getPassword();
			String role = "";

			User user =  userDao.getUser(username, password);
			//Vendor vendor = vendorDao.getVendor(username, password);
			if (user != null) {
				role = user.getRole();
			} 
//		else if (vendor != null) {
//			role = "Vendor";
//		}

			// String role = userWrapper.getRole();
			Map<String, String> map = new HashMap<>();
			if (username != "" && password != "" && role != "") {
				if (!role.equalsIgnoreCase("Vendor")) {
					// UserCredentials user = userDao.getUser(username, password, role);
					logger.info("Inside validation{}}", user);
					logger.info("--------////////Inside Vlidation Line no 134///////////{}}", user);
					if (user != null) {
						if (!Strings.isEmpty(user.getUserName()) && !Strings.isEmpty(user.getPassword())
								&& !Strings.isEmpty(user.getRole())) {
							map.put("id", Integer.toString(user.getId()));
							map.put("userName", user.getUserName());
							map.put("role", user.getRole());
							map.put("firstName", user.getFirstName());
							map.put("lastName", user.getLastName());
							map.put("contactNo", user.getContactNo());
							map.put("emailId", user.getEmailId());
							map.put("address", user.getAddress());
							return map;
						}
					}
				} 
//				else {
//					// Vendor vendor = vendorDao.getVendor(username, password);
//					logger.info("Inside vendor validation{}}", vendor);
//					if (vendor != null) {
//						if (!Strings.isNullOrEmpty(vendor.getUserName())
//								&& !Strings.isNullOrEmpty(vendor.getPassword())) {
//							map.put("id", Integer.toString(vendor.getId()));
//							map.put("userName", vendor.getUserName());
//							map.put("role", "Vendor");
//							return map;
//						}
//					}
				}
			//}
			map.put("message", "Invalid Username or Password");
			map.put("httpResponse", HttpStatus.UNAUTHORIZED.toString());
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashMap<>();
	}

	private ResponseEntity<String> adminSignUp(UserWrapper request) {
		try {
			User uc = new User();
			uc.setUserName(request.getUserName());
			// uc.setUserPassword(getMd5(request.getUserPassword()));
			uc.setPassword(request.getPassword());
			uc.setRole(request.getRole());
			uc.setContactNo(request.getContactNo());
			uc.setAddress(request.getAddress());
			uc.setEmailId(request.getEmailId());
			uc.setFirstName(request.getFirstName());
			uc.setLastName(request.getLastName());
			userDao.save(uc);
			return new ResponseEntity<>("{\"message\":\"" + "Sign Up Successfull !!" + "\"}"+request, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("{\"message\":\"" + "Something went wrong .!!" + "\"}", HttpStatus.OK);
		}
	}

//	private ResponseEntity<String> userSignUp(UserWrapper request) {
//		try {
//			if (validateUser(request) && request.getRole().equalsIgnoreCase("user")) {
//				User uc = new User();
//				uc.setUserName(request.getUserName());
//				uc.setPassword(request.getPassword());
//				uc.setRole(request.getRole());
//				uc.setFirstName(request.getFirstName());
//				uc.setLastName(request.getLastName());
//				uc.setEmailId(request.getEmailId());
//				
//				uc.setContactNo(request.getContactNo());
//				uc.setAddress(request.getAddress());
//				userDao.save(uc);
//				return new ResponseEntity<>("{\"message\":\"" + "Sign Up Successfull" + "\"}"+request, HttpStatus.CREATED);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>("{\"message\":\"" + "User Name id Already EXIST Something Went Wrong" + "\"}", HttpStatus.OK);
//		}
//		return null;
//		
//}
	
	private ResponseEntity userSignUp(UserWrapper request) {
		try {
			if (validateUser(request) && request.getRole().equalsIgnoreCase("user")) {
				User uc = new User();
				uc.setUserName(request.getUserName());
				uc.setPassword(request.getPassword());
				uc.setRole(request.getRole());
				uc.setFirstName(request.getFirstName());
				uc.setLastName(request.getLastName());
				uc.setEmailId(request.getEmailId());
				
				uc.setContactNo(request.getContactNo());
				uc.setAddress(request.getAddress());
				userDao.save(uc);
				return ResponseEntity
			            .status(HttpStatus.CREATED)
			            .body(request);
				//return new ResponseEntity<>("{\"message\":\"" + "Sign Up Successfull" + "\"}"+request, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity
		            .status(HttpStatus.FORBIDDEN)
		            .body("User Already Exists");
			//return new ResponseEntity<>("{\"message\":\"" + "User Name  Already EXIST !!" + "\"}", HttpStatus.UNAUTHORIZED);
		}
		return null;
		
		
	}
	
	@Override
	public List<User> showUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}
	@Override
	public Optional<User> getByID(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}
	@Override
	public User getByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(userName);
	}
	
	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stubus
	  userDao.deleteById(id);
		
	}
	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		User u = userDao.findById(id).get();
		
		u.setAddress(user.getAddress());
		u.setContactNo(user.getContactNo());
		u.setEmailId(user.getEmailId());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		u.setPassword(user.getPassword());
		return userDao.save(u);
		
		
	}
}