package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import domain.TicketForm;


public class TicketFormValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TicketForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TicketForm ticketForm = (TicketForm) target;
		int voetbalCode1 = ticketForm.getVoetbalCode1();
		int voetbalCode2 = ticketForm.getVoetbalCode2();
//		int availableTickets = ticketForm.getAvailableTickets();
		
//		if(ticketForm.getAvailableTickets()-ticketForm.getTickets() < 0) {
//			errors.rejectValue("tickets", "tickets.ticketForm.tickets",
//                    "Te weinig tickets beschikbaar: "+availableTickets+" tickets beschikbaar");
//		}
		
		if(voetbalCode1 >= voetbalCode2) {
			errors.rejectValue("voetbalCode1",
                    "ticketform.voetbalCode1.smaller",
                    "voetbalCode1 must be smaller than voetbalCode2");
			errors.rejectValue("voetbalCode2",
                    "ticketform.voetbalCode1.greater",
                    "voetbalCode2 must be greater than voetbalCode1");
        }
	}

}
