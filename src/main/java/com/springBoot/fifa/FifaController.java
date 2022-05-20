package com.springBoot.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Stadium;
import domain.StadiumBean;
import service.VoetbalServiceImpl;

@Controller
@RequestMapping("/fifa")
public class FifaController {
	
	@Autowired
	private VoetbalServiceImpl voetbalService;

	@GetMapping
	public String showFifaPage(Model model) {
		model.addAttribute("stadiumList", new StadiumBean().getStadiumList());
		model.addAttribute("stadiumCommand", new StadiumCommand());
		
		return "fifa";
	}
	
}
