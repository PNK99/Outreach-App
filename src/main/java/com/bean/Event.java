package com.bean;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Enter the venue place")
	private String place;

	@ManyToOne
	@JoinColumn(name = "activity_id")
	@NotNull(message = "please update the mandatory highlighted fields")
	private Activity activityType;// Activity class

	private Boolean approvalStatus;

	private String benificiary;

	private Double costEstimate;

	private Integer noOfVolunteers;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User suggestedVolunteer;

	//@Future(message = "Enter Future Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@NotBlank(message = "Enter the host's contact number")
	private String contactNumber;

	@NotBlank(message = "Enter  description about the event")
	private String description;

	@NotBlank(message = "Enter Do's and Don't for the event")
	private String dosAndDonts;

	@ManyToMany
	@JoinTable(name = "event_volunteers", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })

	private Set<User> volunteers = new HashSet<>();// Volunteer class

	@ManyToMany
	@JoinTable(name = "event_invite", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> invitedPeople = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "volunteerPresent_event", joinColumns = { @JoinColumn(name = "event_id") }, inverseJoinColumns = {
			@JoinColumn(name = "user_id") })
	private Set<User> voluteerPresent = new HashSet<>();
	
	
	@OneToMany
	@JoinColumn(name="feedback_id")
	private Set<Feedback> feedbacks;

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Boolean getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public User getSuggestedVolunteer() {
		return suggestedVolunteer;
	}

	public void setSuggestedVolunteer(User suggestedVolunteer) {
		this.suggestedVolunteer = suggestedVolunteer;
	}

	public String getBenificiary() {
		return benificiary;
	}

	public void setBenificiary(String benificiary) {
		this.benificiary = benificiary;
	}

	public Double getCostEstimate() {
		return costEstimate;
	}

	public void setCostEstimate(Double costEstimate) {
		this.costEstimate = costEstimate;
	}

	public Integer getNoOfVolunteers() {
		return noOfVolunteers;
	}

	public void setNoOfVolunteers(Integer noOfVolunteers) {
		this.noOfVolunteers = noOfVolunteers;
	}

	public Set<User> getInvitedPeople() {
		return invitedPeople;
	}

	public void setInvitedPeople(Set<User> invitedPeople) {
		this.invitedPeople = invitedPeople;
	}

	private Double donationAmount=0.0;

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

	public Activity getActivityType() {
		return activityType;
	}

	public void setActivityType(Activity activityType) {
		this.activityType = activityType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {

		this.date = date;
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

	public Set<User> getVoluteerPresent() {
		return voluteerPresent;
	}

	public void setVoluteerPresent(Set<User> voluteerPresent) {
		this.voluteerPresent = voluteerPresent;
	}

}