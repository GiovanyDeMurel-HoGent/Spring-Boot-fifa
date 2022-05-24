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
		
		if(voetbalCode1 >= voetbalCode2) {
			errors.rejectValue("voetbalCode1",
                    "voetbalCode.ticketForm.voetbalCode1",
                    "voetbalCode1 moet kleiner zijn dan voetbalCode2");
			errors.rejectValue("voetbalCode2",
                    "voetbalCode.ticketForm.voetbalCode2",
                    "voetbalCode2 moet groter zijn dan voetbalCode1");
        }
	}

}
