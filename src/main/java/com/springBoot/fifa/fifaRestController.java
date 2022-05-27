package com.springBoot.fifa;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Wedstrijd;
import service.WedstrijdDao;

@RestController
@RequestMapping(value = "/fifaDetail")
public class fifaRestController {

	@Autowired
    private WedstrijdDao wedstrijdDao;

    @GetMapping(value = "/{id}") 
    public List<String> getWedstrijd(@PathVariable("id") String id) {
        List<String> landen = new ArrayList<>();
        Wedstrijd wedstrijd = wedstrijdDao.get(Long.parseLong(id));
        landen.add(wedstrijd.getLand1());
        landen.add(wedstrijd.getLand2());
        return landen;
    }
	
}
