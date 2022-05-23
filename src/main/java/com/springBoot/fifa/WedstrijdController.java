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
import domain.WedstrijdTicket;
import service.WedstrijdDao;
import validator.TicketFormValidation;
import validator.WedstrijdTicketValidation;

@Controller
@RequestMapping("*/*")
public class WedstrijdController {
	
	@Autowired
	private WedstrijdDao wedstrijdDao;
	
	@Autowired TicketFormValidation ticketFormValidation;
	
	@GetMapping
	public String showWedstrijdPage(Model model, HttpServletRequest request) {
		long id = Integer.parseInt(request.getParameter("id"));;
		model.addAttribute("wedstrijd", wedstrijdDao.get(id));
		model.addAttribute("ticketform", new TicketForm());
		return "wedstrijdView";
	}
	
	@PostMapping()
	public String onSubmit(@Valid @ModelAttribute("ticketform") TicketForm ticketform, BindingResult result, 
			HttpSession session) {
		//ticketFormValidation.validate(ticketform, result);
		if (result.hasErrors()) {
            return "wedstrijdView";
        }
		else {
//		wedstrijdTicket.setConfirmPassword(null);
//		wedstrijdTicket.setConfirmPassword(null);
		session.setAttribute("aantalGekochteTickets", "x aantal tickets aangekocht");
		return "redirect:/fifa";
		}
	}
}
//@ModelAttribute("ticketform")
