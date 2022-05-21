package com.springBoot.fifa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import domain.Stadium;
import service.StadiumDao;
import service.VoetbalServiceImpl;

@Controller
@RequestMapping("/fifa")
public class FifaController {
	
//	@Autowired
//	private VoetbalServiceImpl voetbalService;
//	@Autowired
//	private ExpertBean expertBean;
	
	@Autowired
	private StadiumDao stadiumDao;
	
	private StadiumCommand stadiumCommand;

	@GetMapping
	public String showFifaPage(Model model) {
//		model.addAttribute("stadiumList", new StadiumBean().getStadiumList());
//		model.addAttribute("stadiumCommand", new StadiumCommand());
		model.addAttribute("stadiumList", stadiumDao.findAll());
		model.addAttribute("stadiumCommand", new StadiumCommand());
		return "fifa";
	}
	
	@PostMapping
	public String onSubmit(Model model) {
		//model.addAttribute("beers", expertBean.getExpert(stadiumcommand.getStadiumSelected()) );
		model.addAttribute("stadium", stadiumCommand.getStadiumSelected());
		//model.addAttribute("wedstrijden", )
		return "stadiumView";
	}
	
}
