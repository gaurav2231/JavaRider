package com.gaurav.Service;

import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gaurav.Entity.Customer;
import com.gaurav.Repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {
	
    @Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String getOtp() {
		 Random rnd = new Random();
		    int number = rnd.nextInt(999999);

		    // this will convert any number sequence into 6 character.
		 System.out.println("OTP is : "+String.format("%06d", number)); 
		 String otp=String.format("%06d", number);
		 return otp;
		
	}

	@Override
	public void login(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
public void register(Customer customer) {
		 customerRepo.save(customer);
	}

} 
