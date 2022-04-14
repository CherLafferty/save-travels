package com.cher.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cher.savetravels.models.Travel;
import com.cher.savetravels.repos.TravelRepo;

@Service
public class TravelService {
	//add travel repo as a dependency
	private final TravelRepo travelRepo;
	
	public TravelService(TravelRepo travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	//READ ALL returns all travel expenses
	public List<Travel> allTravels() {
		return travelRepo.findAll();
	}
	
	//CREATE
	public Travel createTravel(Travel travelExpense) {
		return travelRepo.save(travelExpense);
	}
	
	//READ ONE
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		if(optionalTravel.isPresent()) {
			return optionalTravel.get();
		} else {
			return null;
		}
	}
	
	//UPDATE
	public Travel updateTravel(Travel travel) {
		return travelRepo.save(travel);
	}
	
	//DELETE
	public void delteTravel(Long id) {
		travelRepo.deleteById(id);
	}
	

}
