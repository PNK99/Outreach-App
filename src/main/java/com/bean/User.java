package com.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "please update the mandatory highlighted fields")
	private Integer userId;
	@NotEmpty(message = "please update the mandatory highlighted fields")
	private String firstName;
	@NotEmpty(message = "please update the mandatory highlighted fields")
	private String lastName;
	@NotNull(message = "please update the mandatory highlighted fields")
	private Integer age;
	@NotEmpty(message = "please update the mandatory highlighted fields")
	private String gender;
	@NotEmpty(message = "please update the mandatory highlighted fields")
	private String contactNumber;
	@NotEmpty(message = "please update the mandatory highlighted fields")
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	@NotNull(message = "please update the mandatory highlighted fields")
	private Roles userRole;

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
