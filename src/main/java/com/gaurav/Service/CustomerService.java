package com.gaurav.Service;

import com.gaurav.Entity.Customer;

public interface CustomerService {

	public String getOtp();

	void login(Customer customer);

	void register(Customer customer);


}
