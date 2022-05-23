package com.springBoot.fifa;

import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import domain.Stadium;
import service.JpaStadiumDao;
import service.JpaWedstrijdDao;
import service.StadiumDao;
import service.VoetbalServiceImpl;
import service.WedstrijdDao;

@Controller
//@SessionAttributes("stadium")
@RequestMapping("/fifa")
public class FifaController {
	
//	@Autowired
//	private VoetbalServiceImpl voetbalService;
//	@Autowired
//	private ExpertBean expertBean;
	
	@Autowired
	private StadiumDao stadiumDao;
	
	@Autowired
	private WedstrijdDao wedstrijdDao;
	
	
//	@Autowired
//	private StadiumDao jpaStadiumDao;
	
	private StadiumCommand stadiumCommand;
//	private List<Stadium> stadiumList;
	
	@GetMapping
	public String showFifaPage(Model model) {
//		List<Stadium> stadiumList = stadiumDao.findAll();
		model.addAttribute("stadiumList", stadiumDao.findAll());
		model.addAttribute("stadium", new Stadium());
		return "fifa";
	}
	
//	@PostMapping("/stadiumView")
//	public String onSubmit(
//		@ModelAttribute Stadium selectedStadium, BindingResult result, Model model) {
//		model.addAttribute("stadium", new Stadium());
//		return "stadiumView";
//	}
//	
	@PostMapping()
	public String onSubmit(HttpSession session, @ModelAttribute Stadium stadium, BindingResult result, 
		Model model) {
		session.setAttribute("stadium", stadiumDao.get(stadium.getStadium_id()));
		//model.addAttribute("stadium", stadiumDao.get(stadium.getStadium_id()));
		return String.format("redirect:/%s", session.getAttribute("stadium").toString().replaceAll("\\s", "").replace("Stadium", ""));
	}
	
//	@PostMapping()
//	public String onSubmit(@ModelAttribute("stadium") Stadium stadium, BindingResult result,
//		Model model, HttpServletRequest request, SessionStatus status) {
//		model.addAttribute("stadium", stadiumDao.get(stadium.getStadium_id()));
//		status.setComplete();
//		return "stadiumView";
//	}
	
}
