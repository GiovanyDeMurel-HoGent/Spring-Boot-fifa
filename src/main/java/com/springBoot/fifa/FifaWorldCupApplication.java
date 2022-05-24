package com.springBoot.fifa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import service.JpaStadiumDao;
import service.JpaWedstrijdDao;
import service.StadiumDao;
import service.VoetbalServiceImpl;
import service.WedstrijdDao;
import validator.TicketFormValidation;
import validator.WedstrijdValidation;

@SpringBootApplication
public class FifaWorldCupApplication implements WebMvcConfigurer{
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages_nl");
		return messageSource;
	}
	
	@Bean
	public StadiumDao stadiumDao() {
		return new JpaStadiumDao();
	}
	
	@Bean
	public WedstrijdDao wedstrijdDao() {
		return new JpaWedstrijdDao();
	}
	
	@Bean
	public VoetbalServiceImpl helloService() {
	return new VoetbalServiceImpl();
	}
	
	@Bean
	public WedstrijdValidation wedstrijdValidation() {
		return new WedstrijdValidation();
	}
	
	@Bean
	public TicketFormValidation ticketFormValidation() {
		return new TicketFormValidation();
	}
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/css/**").addResourceLocations("resources/css/");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FifaWorldCupApplication.class, args);
	}

}
