package com.gaurav.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Customer", uniqueConstraints = {@UniqueConstraint(columnNames = {"phoneNumber","userName"})})
//@EntityListeners(AuditingEntityListener.class)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", 
//                      strategy = "org.hibernate.id.UUIDGenerator")
//    @Column(name="reference_id", columnDefinition = "char(36)")
//	@Type(type="org.hibernate.type.UUIDCharType")
    private int id;
	
    @NotBlank (message = "name is required")
    private String name;
    
    @NotBlank (message = "phoneNumber is required")
	private String phoneNumber;
    
   @Email
    private String email;
    
    @NotBlank (message = "userName is required")
	private String userName;
    
   @NotBlank (message = "password is required")
	private String password;
    
   @NotBlank (message = "location is required")
	private String location;
	
     @OneToMany(mappedBy = "customer")
     private Set<BookRide> bookRide;
     
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Customer(int id, String name, String phoneNumber, String email, String userName, String password,
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
