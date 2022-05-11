package com.gaurav.Repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.Entity.BookRide;
import com.gaurav.Entity.Customer;
@Repository
public interface CustomerRepo extends CrudRepository<Customer, UUID> {

	Customer findByPhoneNumber(String phoneNumber);

	boolean existsByEmail(String phoneNumber);

	boolean existsByPassword(String password);





}
