package com.springBoot.fifa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return "fifaView"; 
		//learned the hard way dat dit niet dezelfde naam mag hebben als request mapping uri
	}
	
	@PostMapping()
	public String onSubmit(HttpSession session, @ModelAttribute Stadium stadium, BindingResult result, 
		Model model, HttpServletRequest request) {
		session.setAttribute("stadiumid", request.getParameter("stadium_id"));
		session.setAttribute("stadium", stadiumDao.get(stadium.getStadium_id()));
		return String.format("redirect:/fifa/%s", session.getAttribute("stadium").toString().replaceAll("\\s", "").replace("Stadium", ""));
	}
	
}
