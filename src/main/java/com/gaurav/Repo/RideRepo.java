package com.gaurav.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.Entity.BookRide;

@Repository
public interface RideRepo extends JpaRepository<BookRide, Integer>{


}
