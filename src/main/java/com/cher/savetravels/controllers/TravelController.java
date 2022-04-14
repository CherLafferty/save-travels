package com.cher.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/expenses/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Travel travel = travelRepo.findTravel(id);
		model.addAttribute(travel);
		return "showOne.jsp";
	}

	@PostMapping("/expenses")
	public String create(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {

		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			travelRepo.createTravel(travel);
			return "redirect:/expenses";
		}
	}

	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Travel travel = travelRepo.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}

	@RequestMapping(value = "/expenses/edit/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			travelRepo.updateTravel(travel);
			return "redirect:/expenses";
		}
	}

	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		travelRepo.delteTravel(id);
		return "redirect:/expenses";
	}
}
