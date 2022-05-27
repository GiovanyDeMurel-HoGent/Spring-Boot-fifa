package com.springBoot.fifa;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
@RequestMapping("fifa/*/*")
public class WedstrijdController {
	
	private Locale locale = new Locale("nl");
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private WedstrijdDao wedstrijdDao;
	
	@Autowired TicketFormValidation ticketFormValidation;
	
	@GetMapping
	public String showWedstrijdPage(Model model, HttpServletRequest request, HttpSession session) {
		Wedstrijd wedstrijd = new Wedstrijd();
		wedstrijd = wedstrijdDao.get((long) Integer.parseInt(request.getParameter("id")));
		session.setAttribute("wedstrijd", wedstrijd);
		if(wedstrijd.getTickets() <= 0){
			session.setAttribute("aantalGekochteTickets", messageSource.getMessage("ticketform.soldout", null, locale));
			return "redirect:/fifa";
		}
		TicketForm ticketform = new TicketForm();
		model.addAttribute("ticketform", ticketform);
		session.setAttribute("gametickets",wedstrijd.getTickets());
		return "wedstrijdView";
		
	}
	
	@PostMapping()
	public String onSubmit(@Valid @ModelAttribute("ticketform") TicketForm ticketform, BindingResult result, 
		HttpSession session, Model model) {
		ticketform.setAvailableTickets((int) session.getAttribute("gametickets"));
		ticketFormValidation.validate(ticketform, result);
		if (result.hasErrors()) {
            return "wedstrijdView";
        }
		Wedstrijd wedstrijd = (Wedstrijd) session.getAttribute("wedstrijd");
		wedstrijd.setTickets(wedstrijd.getTickets()-ticketform.getTickets());
		wedstrijdDao.update(wedstrijd);
		
		String gekochteTickets = Integer.toString( ticketform.getTickets())+messageSource.getMessage("ticketform.bought", null, locale);
		session.setAttribute("aantalGekochteTickets", gekochteTickets);
		return "redirect:/fifa";
		
	}
}
