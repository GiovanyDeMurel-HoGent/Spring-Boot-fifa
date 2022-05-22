package com.springBoot.fifa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stadium")
public class StadiumController {

	@GetMapping
	public String showStadiumPage(Model model) {
//		model.addAttribute("stadiumList", new StadiumBean().getStadiumList());
//		model.addAttribute("stadiumCommand", new StadiumCommand());
//		model.addAttribute("stadiumList", stadiumDao.findAll());
//		model.addAttribute("stadiumCommand", new StadiumCommand());
		return "stadium";
	}
	
}
