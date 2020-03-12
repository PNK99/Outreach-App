package com.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "please update the mandatory highlighted fields")
	@Min(value = 100000, message = "User Id should be exactly 6 digits")
	@Max(value = 999999, message = "User Id should be exactly 6 digits")
	private Integer userId;
	
	@NotEmpty(message = "please update the mandatory highlighted fields")
	@Pattern(regexp = "^[a-zA-Z]{2,15}$", message = "First name should only contain alphabets")
	private String firstName;
	
	@NotEmpty(message = "please update the mandatory highlighted fields")
	@Pattern(regexp = "^[a-zA-Z]{1,15}$", message = "Last name should only contain alphabets")
	private String lastName;
	
	@NotNull(message = "please update the mandatory highlighted fields")
	@Min(value = 18, message = "You should be above 18 to enroll")
	private Integer age;
	
	@NotEmpty(message = "please update the mandatory highlighted fields")
	private String gender;
	
	@NotEmpty(message = "please update the mandatory highlighted fields")
	@Size(min = 10 , max = 10, message = "Contact Number should contain exactly 10 digits")
	private String contactNumber;
	
	@NotEmpty(message = "please update the mandatory highlighted fields")
	@Size(min = 8 , max = 15 , message = "Password should be between 8-15 characters")
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	@NotNull(message = "please update the mandatory highlighted fields")
	private Roles userRole;
	
	@OneToMany
	@JoinColumn(name="feedbacks_event")
	private Set<Event> eventFeedback = new HashSet<>();

	private Double wahPoints = 0.0;

	public Double getWahPoints() {
		return wahPoints;
	}

	public Set<Event> getEventFeedback() {
		return eventFeedback;
	}

	public void setEventFeedback(Set<Event> eventFeedback) {
		this.eventFeedback = eventFeedback;
	}

	public void setWahPoints(Double wahPoints) {
		this.wahPoints = wahPoints;
	}

	public Set<Event> getInvitedEvents() {
		return invitedEvents;
	}

	public void setInvitedEvents(Set<Event> invitedEvents) {
		this.invitedEvents = invitedEvents;
	}

	@ManyToMany(mappedBy = "volunteers")
	private Set<Event> events = new HashSet<>();

	@ManyToMany(mappedBy = "voluteerPresent")
	private Set<Event> eventsAttended = new HashSet<>();

	public Set<Event> getEventsAttended() {
		return eventsAttended;
	}

	public void setEventsAttended(Set<Event> eventsAttended) {
		this.eventsAttended = eventsAttended;
	}

	@ManyToMany(mappedBy = "invitedPeople")
	private Set<Event> invitedEvents = new HashSet<>();

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", gender=" + gender + ", contactNumber=" + contactNumber + ", password=" + password
				+ ", userRole=" + userRole + ", wahPoints=" + wahPoints + ", events=" + events + ", eventsAttended="
				+ eventsAttended + ", invitedEvents=" + invitedEvents + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

	}

}
