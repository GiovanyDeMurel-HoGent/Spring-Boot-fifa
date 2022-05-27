package com.springBoot.fifa;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.stream.Stream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;


import domain.TicketForm;
import domain.Wedstrijd;
import service.WedstrijdDao;
import validator.TicketFormValidation;

@SpringBootTest
public class WedstrijdControllerTest {

	private MockMvc mockMvc;
	private WedstrijdController wedstrijdController;
	
	@Mock
	private WedstrijdDao wedstrijdDao;
	@Mock
	TicketFormValidation ticketFormValidation;
	@Mock
	private MessageSource messageSource;

	private MockHttpSession session;

	private Wedstrijd expectedWedstrijd;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		wedstrijdController = new WedstrijdController();
		ticketFormValidation = new TicketFormValidation();
		mockMvc = standaloneSetup(wedstrijdController).build();
		
		expectedWedstrijd = new Wedstrijd((long) 1,"België", "Canada",new Timestamp(2022,11,26,21,0,0,0), (long)1, 35);
	}

	@Test
	public void showWedstrijdPage() throws Exception {
		session = new MockHttpSession();
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameter("id", "1");
		
		when(wedstrijdDao.get((long) Integer.parseInt(request.getParameter("id")))).thenReturn(expectedWedstrijd);
		
		ReflectionTestUtils.setField(wedstrijdController, "wedstrijdDao", wedstrijdDao);
		
		
		mockMvc.perform(get("/fifa/AlBayt/België-Canada").param("id", "1").session(session))
		//.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("wedstrijdView"))
		.andExpect(model().attributeExists("ticketform"))
		.andExpect(request().sessionAttribute("wedstrijd", equalTo(expectedWedstrijd)))
		.andExpect(request().sessionAttribute("gametickets", equalTo(expectedWedstrijd.getTickets())))
		;
	}
	
	@Test
    public void onSubmitSucces() throws Exception {
		session = new MockHttpSession();
		session.setAttribute("gametickets", expectedWedstrijd.getTickets());
		
		session.setAttribute("wedstrijd", expectedWedstrijd);
		TicketForm ticketform = new TicketForm();
		
		when(messageSource.getMessage("ticketform.soldout", null, new Locale("nl"))).thenReturn("voetbalmatch is uitverkocht!");
		
		ReflectionTestUtils.setField(wedstrijdController, "messageSource", messageSource);
		ReflectionTestUtils.setField(wedstrijdController, "wedstrijdDao", wedstrijdDao);
		ReflectionTestUtils.setField(wedstrijdController, "ticketFormValidation", ticketFormValidation);
		
		mockMvc.perform(post("/fifa/AlBayt/België-Canada")
			.session(session)
			.sessionAttr("ticketform", ticketform)
			.param("email", "@")
    		.param("tickets", "5")
    		.param("voetbalCode1", "10")
    		.param("voetbalCode2", "20"))
			.andDo(print())
			.andExpect(status().is(302))
			.andExpect(view().name("redirect:/fifa"));	
	}
	
	private static Stream<Arguments> wrongInputs(){
    	return Stream.of(
    			Arguments.of("someString", "1", "10", "20"),
    			Arguments.of("@", "0", "10", "20"),//0
    			Arguments.of("@", "-1", "10", "20"),//negatief
    			Arguments.of("@", "36", "10", "20"),//tickets > beschikbare tickets grenswaarde
    			Arguments.of("@", "50", "10", "20"),//tickets > > beschikbare tickets
    			Arguments.of("@", "1", "21", "20"),//Voetbalcode1 > voetbalcode2 grenswaarde
    			Arguments.of("@", "1", "50", "20"),//Voetbalcode1 > voetbalcode2
    			Arguments.of("", "1", "10", "20"),//email empty
    			Arguments.of("@", "", "10", "20"),//tickets empty
    			Arguments.of("@", "1", "", "20"),//voetbalCode1 empty
    			Arguments.of("@", "1", "10", "")//voetbalCode2 empty
    			);
    }
	
	@ParameterizedTest
	@MethodSource("wrongInputs")
    public void onSubmitFail(String email, String tickets, String voetbalCode1, String voetbalCode2) throws Exception {
		session = new MockHttpSession();
		session.setAttribute("gametickets", expectedWedstrijd.getTickets());
		
		session.setAttribute("wedstrijd", expectedWedstrijd);
		TicketForm ticketform = new TicketForm();
		
		when(messageSource.getMessage("ticketform.soldout", null, new Locale("nl"))).thenReturn("voetbalmatch is uitverkocht!");
		
		ReflectionTestUtils.setField(wedstrijdController, "messageSource", messageSource);
		ReflectionTestUtils.setField(wedstrijdController, "wedstrijdDao", wedstrijdDao);
		ReflectionTestUtils.setField(wedstrijdController, "ticketFormValidation", ticketFormValidation);
		
		mockMvc.perform(post("/fifa/AlBayt/België-Canada")
			.session(session)
			.sessionAttr("ticketform", ticketform)
			.param("email", email)
    		.param("tickets", tickets)
    		.param("voetbalCode1", voetbalCode1)
    		.param("voetbalCode2", voetbalCode2))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("wedstrijdView"));	
	}
//    	Stadium stadium1 = new Stadium("stad", "1");
//    	Wedstrijd wedstrijd1 = new Wedstrijd("1", "land", "anderLand", 15, 14, 14, stadium1);
//    	
//    	List<Wedstrijd> expwedstrijden1 = new ArrayList<>();
//    	expwedstrijden1.add(wedstrijd1);
//        Mockito.when(wedstrijdDaoMock.getAllWedstrijdenByStadiumId(stadium1.getId())).thenReturn(expwedstrijden1);
//    	Mockito.when(wedstrijdDaoMock.getWedstrijdByWedstrijdId(wedstrijd1.getId())).thenReturn(wedstrijd1);
//   	
//        
//        //injectie:
//        ReflectionTestUtils.setField(controller, "wedstrijdDao", wedstrijdDaoMock);
//        ReflectionTestUtils.setField(controller, "ticketFormValidation", ticketFormValidation);
//        
//        mockMvc.perform(get("/fifa/1"));
//        mockMvc.perform(post("/fifa/1")
//        		.sessionAttr("wedstrijdTicketForm", wedstrijd1)
//        		.param("email", "ei@iets.com")
//        		.param("aantal", "5")
//        		.param("voetbalCode1", "10")
//        		.param("voetbalCode2", "20")
//        		)
//        		.andDo(print())
//                .andExpect(view().name("redirect:/fifa?verkocht=" + "5"));
//    }

}
