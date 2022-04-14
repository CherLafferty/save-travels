package com.cher.savetravels.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cher.savetravels.models.Travel;

@Repository
public interface TravelRepo extends CrudRepository<Travel, Long> {
    // this method retrieves all the travels from the database
    List<Travel> findAll();
	
}
