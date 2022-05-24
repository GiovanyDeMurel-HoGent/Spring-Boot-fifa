package com.springBoot.fifa;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Stadium;
import service.StadiumDao;

@Controller
@RequestMapping("/fifa")
public class FifaController {
	
	@Autowired
	private StadiumDao stadiumDao;
	
	@GetMapping
	public String showFifaPage(Model model) {
		model.addAttribute("stadiumList", stadiumDao.findAll());
		model.addAttribute("stadium", new Stadium());
		return "fifa";
	}
	
	@PostMapping()
	public String onSubmit(HttpSession session, @ModelAttribute Stadium stadium, BindingResult result, 
		Model model) {
		session.setAttribute("stadium", stadiumDao.get(stadium.getStadium_id()));
		//session.setAttribute("aantalGekochteTickets", "");
		return String.format("redirect:/%s", session.getAttribute("stadium").toString().replaceAll("\\s", "").replace("Stadium", ""));
	}
	
}
