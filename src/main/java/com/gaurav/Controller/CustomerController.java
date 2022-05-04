package com.gaurav.Controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.Entity.CacheM;
import com.gaurav.Entity.Customer;
import com.gaurav.Entity.Response;
import com.gaurav.Repo.CustomerRepo;
import com.gaurav.Service.CustomerService;


@EnableCaching
@RestController
public class CustomerController {
		
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerService customerService;

	static Map<String, Object> inMemoryDataMap=new HashMap<>();

	@PostMapping("/Register")
	public ResponseEntity<Response> Register(@RequestBody Customer customer, CacheM cachem) {
		
		Response response=new Response();
		
    	String otp = customerService.getOtp();
		customerService.register(customer);
		cachem.setOtp(otp);
		inMemoryDataMap.put("otp", cachem);
		response.setMessage("Customer Registered Successfully!!!");
		
		return ResponseEntity.ok().body(response);
	
	}
	
	
	@PostMapping("Login")
	public ResponseEntity<Response> Login(@RequestBody Customer customer) {
		Response response=new Response();
		customerService.login(customer);
		response.setMessage("Customer Login Successfully!!!");
		return ResponseEntity.ok().body(response);
	}
	
	
	@GetMapping("/GenerateOTP")
	@Cacheable(value="otp")
	public ResponseEntity<Object> otp(CacheM cachem) {
		//Cache cache=new Cache();
		String otp=customerService.getOtp();
		//cache.setOt
		//System.out.println(customerService.getOtp());
	    cachem.setOtp(otp);
		inMemoryDataMap.put("otp", cachem);
		return ResponseEntity.ok(cachem);
	}
	
	
	@PostMapping("/checkOtp")
	public ResponseEntity<Response>  checkOtp(@RequestBody CacheM cachem)
	{
		Response message =new Response();
		CacheM otp =(CacheM) inMemoryDataMap.get("otp");
		if(otp.getOtp().matches(cachem.getOtp()) && cachem.getExpiryTime().getTime()>System.currentTimeMillis())
		 {
			message.setMessage("Otp Verified Successfully!!!");
			return ResponseEntity.ok().body(message);
          }
		else 
		{
			message.setMessage("Enter Valid Otp!!!");
		       return ResponseEntity.badRequest().body(message);
		}
	}
}
