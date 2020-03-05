package com.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message="Enter the venue place")
	private String place;

	private String activity;// Activity class
	
	@FutureOrPresent(message="Enter Future Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@NotBlank(message="Enter the host's contact number")
	private String contactNumber;

	@NotBlank(message="Enter  description about the event")
	private String description;

	@NotBlank(message="Enter Do's and Don't for the event")
	private String dosAndDonts;

	@ManyToMany
	@JoinTable(name = "event_volunteers", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> volunteers = new HashSet<>();// Volunteer class

	private Double donationAmount;

	private String voluteerPresent;// Volunteer class

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		
		/*
		 * SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); try { this.date
		 * = format.parse(date); } catch (ParseException e) { // TODO Auto-generated
		 * e.printStackTrace(); }
		 */
		 
		
		this.date=date;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDosAndDonts() {
		return dosAndDonts;
	}

	public void setDosAndDonts(String dosAndDonts) {
		this.dosAndDonts = dosAndDonts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getVolunteers() {
		return volunteers;
	}

	public void setVolunteers(Set<User> volunteers) {
		this.volunteers = volunteers;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(Double donationAmount) {
		this.donationAmount = donationAmount;
	}

	public String getVoluteerPresent() {
		return voluteerPresent;
	}

	public void setVoluteerPresent(String voluteerPresent) {
		this.voluteerPresent = voluteerPresent;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", place=" + place + ", activity=" + activity + ", date=" + date + ", contactNumber="
				+ contactNumber + ", DosAndDonts=" + dosAndDonts + ", donationAmount=" + donationAmount
				+ ", voluteerPresent=" + voluteerPresent + "]";
	}

}
