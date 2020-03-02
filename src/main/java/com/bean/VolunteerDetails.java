package com.bean;


import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;




public class VolunteerDetails {
	
	
@NotEmpty(message="please update the mandatory highlighted fields" )
private String firstName;


@NotEmpty(message="please update the mandatory highlighted fields")
private String lastName;



//@NotEmpty(message="please update the mandatory highlighted fields")
private int age;



@NotEmpty(message="please update the mandatory highlighted fields")
private String gender;


//@NotEmpty(message="please update the mandatory highlighted fields")
private int contactNumber;


//@NotEmpty(message="please update the mandatory highlighted fields")
private int volunteerId;



@NotEmpty(message="please update the mandatory highlighted fields")
private String password;



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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getContactNumber() {
	return contactNumber;
}
public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}
public int getVolunteerId() {
	return volunteerId;
}
public void setVolunteerId(int volunteerId) {
	this.volunteerId = volunteerId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
