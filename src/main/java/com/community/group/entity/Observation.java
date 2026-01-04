package com.community.group.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Observation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postcode;
	private String measurement;
	private String description;
	private String authority; // Local authority name
	
	private int points;
	
	private LocalDateTime createdAt;
	
	
	@ManyToOne
	private User user;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getMeasurement() {
		return measurement;
	}


	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Observation [id=" + id + ", postcode=" + postcode + ", measurement=" + measurement + ", description="
				+ description + ", authority=" + authority + ", points=" + points + ", createdAt=" + createdAt
				+ ", user=" + user + "]";
	}


	public Observation(Long id, String postcode, String measurement, String description, String authority, int points,
			LocalDateTime createdAt, User user) {
		super();
		this.id = id;
		this.postcode = postcode;
		this.measurement = measurement;
		this.description = description;
		this.authority = authority;
		this.points = points;
		this.createdAt = createdAt;
		this.user = user;
	}


	public Observation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
