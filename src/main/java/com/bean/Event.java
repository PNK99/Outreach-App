package com.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String place;

	private String activity;// Activity class

	private Date date;

	private String contactNumber;
	
	private String description;

	private String DosAndDonts;

	private String volunteerId;// Volunteer class

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

	public void setDate(String date) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date=format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDosAndDonts() {
		return DosAndDonts;
	}

	public void setDosAndDonts(String dosAndDonts) {
		DosAndDonts = dosAndDonts;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
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
				+ contactNumber + ", DosAndDonts=" + DosAndDonts + ", volunteerId=" + volunteerId + ", donationAmount="
				+ donationAmount + ", voluteerPresent=" + voluteerPresent + "]";
	}
	
	

}
