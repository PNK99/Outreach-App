package com.bean;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




public class VolunteerDetails {
	
	
	
private String userRole;
	
@NotEmpty(message="please update the mandatory highlighted fields" )
private String firstName;


@NotEmpty(message="please update the mandatory highlighted fields")
private String lastName;



@NotNull(message="please update the mandatory highlighted fields")
private Integer age;



@NotEmpty(message="please update the mandatory highlighted fields")
private String gender;


@NotNull(message="please update the mandatory highlighted fields")
private String contactNumber;


@NotNull(message="please update the mandatory highlighted fields")
private Integer volunteerId;



@NotEmpty(message="please update the mandatory highlighted fields")
private String password;



public String getUserRole() {
	return userRole;
}



public void setUserRole(String userRole) {
	this.userRole = userRole;
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



public Integer getVolunteerId() {
	return volunteerId;
}



public void setVolunteerId(Integer volunteerId) {
	this.volunteerId = volunteerId;
}



public String getPassword() {
	return password;
}



public void setPassword(String password) {
	this.password = password;
}





}
