package com.springBoot.fifa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.TicketForm;
import domain.Wedstrijd;
import service.WedstrijdDao;
import validator.TicketFormValidation;

@Controller
@RequestMapping("*/*")
public class WedstrijdController {
	
	@Autowired
	private WedstrijdDao wedstrijdDao;
	
	@Autowired TicketFormValidation ticketFormValidation;
	
	@GetMapping
	public String showWedstrijdPage(Model model, HttpServletRequest request, HttpSession session) {
		Wedstrijd wedstrijd = new Wedstrijd();
		wedstrijd = wedstrijdDao.get((long) Integer.parseInt(request.getParameter("id")));
		session.setAttribute("wedstrijd", wedstrijd);
		TicketForm ticketform = new TicketForm();
		ticketform.setAvailableTickets(wedstrijd.getTickets());
		model.addAttribute("ticketform", ticketform);
		return "wedstrijdView";
	}
	
	@PostMapping()
	public String onSubmit(@Valid @ModelAttribute("ticketform") TicketForm ticketform, BindingResult result, 
		HttpSession session, Model model) {
		
		ticketFormValidation.validate(ticketform, result);
		if (result.hasErrors()) {
            return "wedstrijdView";
        }
		Wedstrijd wedstrijd = (Wedstrijd) session.getAttribute("wedstrijd");
		wedstrijd.setTickets(wedstrijd.getTickets()-ticketform.getTickets());
		
		wedstrijdDao.update(wedstrijd);
		String gekochteTickets = Integer.toString( ticketform.getTickets())+" tickets werden aangekocht";
//		wedstrijdTicket.setConfirmPassword(null);
//		wedstrijdTicket.setConfirmPassword(null);
		session.setAttribute("aantalGekochteTickets", gekochteTickets);
		return "redirect:/fifa";
		
	}
}
