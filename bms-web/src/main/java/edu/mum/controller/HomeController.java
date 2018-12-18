package edu.mum.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Trip;
import edu.mum.service.TripService;

  
@Controller
public class HomeController {
	
	@Autowired
	private TripService tripService;
	
	@ModelAttribute("trips")
	private List<Trip> trips() {
		return tripService.findAll();
	}
	
	@RequestMapping({"", "/","/welcome"})
	public String welcome(Authentication authentication) {
//		model.addAttribute("trips", tripService.findAll());
		if (authentication != null ) {
			
			Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
	        if (roles.contains("ROLE_ADMIN")){
	            return "redirect:/admin";
	        }
		}
		return "redirect:/trips";
	}
	
	@RequestMapping(value = {"/admin", "/admin/", "/admin/index"}, method = RequestMethod.GET)
	public String admin() {
		
		return "redirect:/admin/trip";
	}
}
