package com.springBoot.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Wedstrijd;
import validator.WedstrijdValidation;

@Controller
@RequestMapping("/wedstrijd")
public class WedstrijdController {

	@Autowired
	private WedstrijdValidation wedstrijdValidation;
	
	@GetMapping
	public String showWedstrijdPage(Model model) {
		//model.addAttribute("wedstrijd", new Wedstrijd());
		return "wedstrijd";
	}
}
