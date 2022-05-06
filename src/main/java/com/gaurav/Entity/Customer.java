package com.gaurav.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"phoneNumber","userName"})})
//@EntityListeners(AuditingEntityListener.class)
public class Customer {

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", 
                      strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="reference_id", columnDefinition = "char(36)")
	@Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
	
    @NotBlank (message = "name is required")
    private String name;
    
    @NotBlank (message = "phoneNumber is required")
    @Size(min = 3, max = 10, message = "Size must between 3 and 10")
	private String phoneNumber;
    
    @Email(message = "provide valid format")
    private String email;
    
    @NotBlank (message = "userName is required")
	private String userName;
    
   @NotBlank (message = "password is required")
	private String password;
    
   @NotBlank (message = "location is required")
	private String location;
	
   @NotBlank (message = "latitude is required")
	private String latitude;

   @NotBlank (message = "longitude is required")
	private String longitude;
	


	public String getLatitude() {
	return latitude;
}

public void setLatitude(String latitude) {
	this.latitude = latitude;
}

public String getLongitude() {
	return longitude;
}

public void setLongitude(String longitude) {
	this.longitude = longitude;
}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Customer(UUID id, String name, String phoneNumber, String email, String userName, String password,
			String location) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.location = location;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
