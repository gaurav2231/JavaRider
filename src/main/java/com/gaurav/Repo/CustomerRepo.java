package com.gaurav.Repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.gaurav.Entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, UUID> {

	Customer findByPhoneNumber(String phoneNumber);

	boolean existsByEmail(String phoneNumber);

	boolean existsByPassword(String password);




}
