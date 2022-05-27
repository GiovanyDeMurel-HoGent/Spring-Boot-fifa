package com.springBoot.fifa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import domain.Stadium;
import domain.Wedstrijd;
import service.StadiumDao;
import service.WedstrijdDao;

@SpringBootTest
public class StadiumControllerTest {
	
	private MockMvc mockMvc;
	private StadiumController stadiumController;
	@Mock
	private WedstrijdDao wedstrijdDao;
	
	private MockHttpSession session;
	
	private Wedstrijd expectedWedstrijd;
	private List<Wedstrijd> expectedWedstrijden;
	private Stadium stadium;

	
	@SuppressWarnings("deprecation")
	@BeforeEach
	  public void setUp() {
		MockitoAnnotations.openMocks(this);
		stadiumController = new StadiumController();
	    mockMvc  = standaloneSetup(stadiumController).build();
	    stadium = new Stadium((long) 1, "Al Bayt Stadium");
	    
	    Wedstrijd expectedWedstrijd1 = new Wedstrijd((long) 1,"België", "Canada",new Timestamp(2022,11,26,21,0,0,0), (long)1, 35);
	    Wedstrijd expectedWedstrijd2 = new Wedstrijd((long) 2,"Brazilië", "Zwitserland", new Timestamp(2022,11,27,18,0,0,0), (long)1, 21);
	    Wedstrijd expectedWedstrijd3 = new Wedstrijd((long) 3,"Marroko", "Kroatië", new Timestamp(2022,11,28,15,0,0,0), (long)1, 0);
	    Wedstrijd expectedWedstrijd4 = new Wedstrijd((long) 4,"Argentinië", "Mexico", new Timestamp(2022,11,30,18,0,0,0), (long)1, 10);
	    Wedstrijd expectedWedstrijd5 = new Wedstrijd((long) 5,"Engeland", "USA", new Timestamp(2022,12,01,18,0,0,0), (long)1, 22);
	    expectedWedstrijden = new ArrayList<>();
	    expectedWedstrijden.add(expectedWedstrijd1);
	    expectedWedstrijden.add(expectedWedstrijd2);
	    expectedWedstrijden.add(expectedWedstrijd3);
	    expectedWedstrijden.add(expectedWedstrijd4);
	    expectedWedstrijden.add(expectedWedstrijd5);
	    System.out.println(expectedWedstrijd1);
	 }
	
	@Test
	public void showStadiumPage() throws Exception {
		session = new MockHttpSession();
		session.setAttribute("stadium", stadium);
		when(wedstrijdDao.getAllWedstrijdenByStadiumId((long)1)).thenReturn(expectedWedstrijden);
		
		ReflectionTestUtils.setField(stadiumController, "wedstrijdDao", wedstrijdDao);
		
		mockMvc.perform(get("/fifa/AlBayt").session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("stadiumView"))
		.andExpect(request().sessionAttribute("wedstrijden", equalTo(expectedWedstrijden)))
		.andExpect(model().attributeExists("wedstrijd"))
		;
	}
	
}
