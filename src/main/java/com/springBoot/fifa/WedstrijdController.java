package com.springBoot.fifa;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		String id = request.getParameter("id");
	
		System.out.println("ID: "+id);
		//Wedstrijd wedstrijd = wedstrijdDao.get(null)
		return "wedstrijdView";
	}
}
