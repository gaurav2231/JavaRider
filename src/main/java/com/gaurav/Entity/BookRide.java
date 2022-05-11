package com.gaurav.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.gaurav.util.RideStatus;
@Entity
public class BookRide {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String source;
	
	private String destination;
	
	private double fair;
	
	private RideStatus status= RideStatus.Initiate;
	
	private double distance;


	@ManyToOne()
	@JoinColumn(name="customerId", referencedColumnName = "id")
	private Customer customer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getFair() {
		return fair;
	}
	public void setFair(double fair) {
		this.fair = fair;
	}
	public RideStatus getStatus() {
		return status;
	}
	public void setStatus(RideStatus status) {
		this.status = status;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public BookRide(int id, String source, String destination, double fair,RideStatus status,
			double distance, Customer customer) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.fair = fair;
		this.status = status;
		this.distance = distance;
		this.customer = customer;
	}
	public BookRide()
	{
		
	}
	
}
