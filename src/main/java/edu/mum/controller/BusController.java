package edu.mum.controller;

import edu.mum.domain.Bus;
import edu.mum.service.BusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @RequestMapping(value={"", "/","/index"}, method=RequestMethod.GET)
    public String buss(Model model) {
    	model.addAttribute("buss", busService.findAll());
        return "admin/bus";
    }

    @RequestMapping(value="/new")
	public String newBusForm(Model model){
		model.addAttribute("bus", new Bus());
		return "admin/bus/new";
	}

	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String addNewBus(@Valid @ModelAttribute("bus") Bus bus,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "admin/bus/new";
		}
		bus = busService.save(bus);
		return "redirect:/admin/bus";
	}

    @RequestMapping(value = "/edit/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("bus", this.busService.findOne(id));
        return "admin/bus/edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("bus") Bus bus, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/bus/edit";
        }
        this.busService.save(bus); // operator.id already set by binding

        return "redirect:/admin/bus";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody Bus addBus(@Valid @RequestBody Bus bus) {
		long busId = busService.saveBus(bus);
		bus.setId(busId);
		return bus;
	}

}
