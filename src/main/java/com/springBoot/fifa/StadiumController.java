package com.springBoot.fifa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.Stadium;
import domain.Wedstrijd;
import service.StadiumDao;
import service.WedstrijdDao;

@Controller
@SessionAttributes("stadium")
@RequestMapping("/stadiumView")
public class StadiumController {

	@Autowired
	private StadiumDao stadiumDao;
	@Autowired
	private WedstrijdDao wedstrijdDao;
	
	@GetMapping()
	public String showStadiumPage(HttpSession session, @ModelAttribute Wedstrijd wedstrijd, BindingResult result, Model model) {
		//Stadium stadium = (Stadium) model.getAttribute("stadium");
		//model.addAttribute("stadium",)
		Stadium stadium = (Stadium) session.getAttribute("stadium");
		model.addAttribute("wedstrijden",wedstrijdDao.getAllWedstrijdenByStadiumId(stadium.getStadium_id()));
		//model.addAttribute("wedstrijden", stadiumDao.) );
		return "stadiumView";
	}
	
}