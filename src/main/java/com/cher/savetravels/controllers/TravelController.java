package com.cher.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cher.savetravels.models.Travel;
import com.cher.savetravels.services.TravelService;

@Controller
public class TravelController {
	
	@Autowired
	TravelService travelRepo;
	
	@GetMapping("/expenses")
	public String index(Model model, @ModelAttribute("travel") Travel travel) {
		List<Travel> allTravels = travelRepo.allTravels();
		model.addAttribute("allTravels", allTravels);
		
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String create(
			@Valid @ModelAttribute("travel") Travel travel,
			BindingResult result) {
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			travelRepo.createTravel(travel);
			return "redirect:/expenses";
		}
	}

}
