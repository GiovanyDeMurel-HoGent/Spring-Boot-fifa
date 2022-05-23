package com.springBoot.fifa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.Stadium;
import domain.Wedstrijd;
import service.WedstrijdDao;
import validator.WedstrijdValidation;

@Controller
@RequestMapping("*/*")
public class WedstrijdController {

	@Autowired
	private WedstrijdValidation wedstrijdValidation;
	
	@Autowired
	private WedstrijdDao wedstrijdDao;
	
	@GetMapping
	public String showWedstrijdPage(Model model, HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));
		//Wedstrijd wedstrijd = wedstrijdDao.get(null)
		model.addAttribute("wedstrijd", wedstrijdDao.get(id));
		return "wedstrijdView";
	}
	
	@PostMapping()
	public String onSubmit(HttpSession session, @ModelAttribute Wedstrijd wedstrijd, BindingResult result, 
		Model model) {
		session.setAttribute("aantalGekochteTickets", "x aantal tickets aangekocht");
		return "redirect:/fifa";
	}
}
