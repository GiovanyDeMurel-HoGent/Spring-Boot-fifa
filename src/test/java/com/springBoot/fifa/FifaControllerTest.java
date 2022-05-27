package com.springBoot.fifa;


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import service.StadiumDao;

@SpringBootTest
public class FifaControllerTest {
	
	private MockMvc mockMvc;
	private FifaController fifaController;
	@Mock
	private StadiumDao stadiumDao;
	
	private MockHttpSession session;
	
	private Stadium expectedStadium;
	private List<Stadium> expectedStadiumList;
	
	@BeforeEach
	  public void setUp() {
		MockitoAnnotations.openMocks(this);
		fifaController = new FifaController();
	    mockMvc  = standaloneSetup(fifaController).build();
	    expectedStadium = new Stadium((long) 1, "Al Bayt Stadium");
		expectedStadiumList = new ArrayList<>();
		expectedStadiumList.add(expectedStadium);
		expectedStadiumList.add(new Stadium((long) 2, "Al Thumama Stadium" ));
	 }

	
	@Test
	public void showFifaPage() throws Exception {
		
		when(stadiumDao.get((long) 1)).thenReturn(expectedStadium);
		when(stadiumDao.findAll()).thenReturn(expectedStadiumList);
		
		ReflectionTestUtils.setField(fifaController, "stadiumDao", stadiumDao);
		
		mockMvc.perform(get("/fifa"))
		//.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("fifaView"))
		.andExpect(model().attributeExists("stadiumList"))
		.andExpect(model().attribute("stadiumList", expectedStadiumList))
		.andExpect(model().attributeExists("stadium"))
		;
	}
	
	@Test
    public void onSubmit() throws Exception {
		session = new MockHttpSession();
		
		when(stadiumDao.get((long) 1)).thenReturn(expectedStadium);
		
        ReflectionTestUtils.setField(fifaController, "stadiumDao", stadiumDao);

		mockMvc.perform(post("/fifa/").param("stadium_id","1").session(session))
			//.andDo(print())
			.andExpect(status().is(302))
			.andExpect(view().name("redirect:/fifa/AlBayt"))
			.andExpect(request().sessionAttribute("brol", is(nullValue())))
			.andExpect(request().sessionAttribute("stadiumid", equalTo(Long.toString(expectedStadium.getStadium_id()))))
			.andExpect(request().sessionAttribute("stadium", equalTo(expectedStadium)))
			;
	}

}
