package com.inn.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//@NamedQuery(name = "UserCredentials.getUser", query = "select u from UserCredentials u where u.userName=:username and u.userPassword=:password and userRole=:role")
@NamedQuery(name = "User.getUser", query = "select u from User u where u.userName=:username and u.password=:password")


@NamedQuery(name = "User.validUser", query = "select u.userName,u.password,u.role from User u where u.userName=:username")

@Entity
@Table(name = "UserDetail" ,uniqueConstraints={@UniqueConstraint(columnNames = {"userName" })})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Integer id;
	
	@Basic
	@Column
	private String firstName;
	
	@Basic
	@Column
	private String lastName;
	
	@Basic
	@Column
	private String emailId ;
	
	@Basic
	@Column
	private String contactNo;
	
	@Basic
	@Column
	private String address;
	
	@Basic 
	@Column 
	private String password;
	
	@Basic 
	@Column
	private String role;
	
	@Basic
	@Column
	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", contactNo=" + contactNo + ", address=" + address + ", password=" + password + ", role=" + role
				+ ", userName=" + userName + "]";
	}

	public User(Integer id, String firstName, String lastName, String emailId, String contactNo, String address,
			String password, String role, String userName) {
		super();
		this.id = id;
		this.firstName =firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.address = address;
		this.password = password;
		this.role = role;
		this.userName = userName;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	

}
