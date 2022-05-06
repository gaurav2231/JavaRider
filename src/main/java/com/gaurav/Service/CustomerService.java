package com.gaurav.Service;

import com.gaurav.Entity.Customer;

public interface CustomerService {

	public String getOtp();

	void register(Customer customer);
	
	public void sendEmail(String subject , String From , String To , String content);


}
