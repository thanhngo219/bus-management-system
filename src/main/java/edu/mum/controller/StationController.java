package edu.mum.controller;

import edu.mum.domain.Station;
import edu.mum.service.StationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/station")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(value = "", method = RequestMethod.GET)
	public String flights(Model model) {
		model.addAttribute("stations", stationService.findAll());
		return "admin/station";
	}
    
    @RequestMapping(value="/new", method = RequestMethod.GET)
	public String newAirplaneForm(Model model){
		model.addAttribute("station", new Station());
		return "admin/station/new";
	}

	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String addNewAirplane(@Valid @ModelAttribute("station") Station station,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/station/new";
		}
		station = stationService.save(station);
		return "redirect:/admin/station";
	}

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.GET)
    public String get(@PathVariable("id")Long id, Model model) {
        model.addAttribute("station", this.stationService.findOne(id));
        return "admin/station/edit";
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("station") Station station, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/station/edit";
        }
        this.stationService.save(station); // station.id already set by binding

        return "redirect:/admin/station";
    }
}
