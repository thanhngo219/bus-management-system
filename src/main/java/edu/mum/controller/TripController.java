package edu.mum.controller;

import java.util.List;

import javax.validation.Valid;

import edu.mum.domain.Operator;
import edu.mum.domain.Bus;
import edu.mum.domain.Station;
import edu.mum.domain.Trip;
import edu.mum.service.OperatorService;
import edu.mum.service.BusService;
import edu.mum.service.StationService;
import edu.mum.service.TripService;
import edu.mum.validator.TripScheduleValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value = "/admin/trip")
public class TripController {

	@Autowired
	private TripService tripService;

	@Autowired
	private StationService stationService;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private BusService busService;
	
	@Autowired
	private TripScheduleValidator tripScheduleValidator;
	
	@ModelAttribute("operators")
	private List<Operator> getOperators(){
		return operatorService.findAll();
	}
	
	@ModelAttribute("busStations")
	private List<Station> getStations(){
		return stationService.findAll();
	}
	
	@ModelAttribute("buses")
	private List<Bus> getBuses(){
		return busService.findAll();
	}

	@RequestMapping(value={"/admin/trip", "/admin/trip/","/admin/trip/index"}, method = RequestMethod.GET)
	public String adminFlights(Model model) {
		model.addAttribute("trips", tripService.findAll());
		return "admin/trip";
	}
	
	@RequestMapping(value = "/trips", method = RequestMethod.GET)
	public String trips(Model model) {		
		model.addAttribute("trips", tripService.findAll());
		return "trip/index";
	}
	
	@RequestMapping(value = "/admin/trip/new", method = RequestMethod.GET)
	public String newFlightForm(@ModelAttribute("trip")Trip trip, Model model){
		
		return "admin/trip/new";
	}

	@RequestMapping(value = "/admin/trip/new", method = RequestMethod.POST)
	public String scheduleNewFlight(@Valid @ModelAttribute("trip") Trip trip,
			BindingResult bindingResult, Model model) {
		
		tripScheduleValidator.validate(trip, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/trip/new";
		}
		trip = tripService.save(trip);
		return "redirect:/admin/trip";
	}

	@RequestMapping(value = "/admin/trip/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Long id, Model model){
		Trip trip = tripService.findOne(id);
		if (trip != null) {
			model.addAttribute("trip", trip);
			return "admin/trip/edit";
		}
		
		return "admin/trips";
	}
	@RequestMapping(value = "/admin/trip/edit/{id}", method = RequestMethod.GET)
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("trip", this.tripService.findOne(id));
        return "admin/trip/edit";
    }
	
	@RequestMapping(value= "/admin/trip/edit/{id}", method = RequestMethod.POST)
	public String editFlight(@Valid @ModelAttribute("trip") Trip trip,
							 BindingResult bindingResult, Model model) {
		
		tripScheduleValidator.validate(trip, bindingResult);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/trip/edit";
		}
		tripService.save(trip); // trip.id already set by binding
		return "redirect:/admin/trip";
	}

}
