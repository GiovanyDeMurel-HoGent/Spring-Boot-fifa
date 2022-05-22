package com.springBoot.fifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.JpaStadiumDao;
import service.StadiumDao;
import service.VoetbalServiceImpl;
import validator.WedstrijdTicketValidation;
import validator.WedstrijdValidation;

@SpringBootApplication
public class FifaWorldCupApplication implements WebMvcConfigurer{

	@Bean
	public JpaStadiumDao stadiumDao() {
		return new JpaStadiumDao();
	}
	
//	@Bean
//	public JpaStadiumDao JpaStadiumDao() {
//		return new JpaStadiumDao();
//	}
	
	@Bean
	public VoetbalServiceImpl helloService() {
	return new VoetbalServiceImpl();
	}
	
	@Bean
	public WedstrijdValidation wedstrijdValidation() {
		return new WedstrijdValidation();
	}
	
	@Bean
	public WedstrijdTicketValidation wedstrijdTicketValidation() {
		return new WedstrijdTicketValidation();
	}
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FifaWorldCupApplication.class, args);
	}

}
