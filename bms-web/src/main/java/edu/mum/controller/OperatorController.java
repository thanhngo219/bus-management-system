package edu.mum.controller;

import edu.mum.domain.Operator;
import edu.mum.service.OperatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/operator")
public class OperatorController{

    @Autowired
    private OperatorService operatorService;

    @RequestMapping(value={"", "/","/index"}, method=RequestMethod.GET)
    public String operators(Model model) {
    	model.addAttribute("operators", operatorService.findAll());
        return "admin/operator";
    }

    @RequestMapping(value = "/new", method=RequestMethod.GET)
    public String newOperatorForm(@ModelAttribute("operator") Operator operator, Model model) {
    	model.addAttribute("operator", new Operator());
    	return "admin/operator/new";
    }

    @RequestMapping(value = "/new", method=RequestMethod.POST)
    public String addNewOperator(@Valid @ModelAttribute("operator") Operator operator,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/operator/new";
        }
        operator = operatorService.save(operator);
        return "redirect:/admin/operator";
    }

    @RequestMapping(value = "/edit/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("operator", this.operatorService.findOne(id));
        return "admin/operator/edit";
    }

    @RequestMapping(value = "/edit/{id}", method=RequestMethod.POST)
    public String update(@PathVariable long id, @Valid @ModelAttribute("operator")  Operator operator, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "admin/operator/edit";
        }

        operatorService.save(operator); // operator.id already set by binding
        return "redirect:/admin/operator";
    }


}
