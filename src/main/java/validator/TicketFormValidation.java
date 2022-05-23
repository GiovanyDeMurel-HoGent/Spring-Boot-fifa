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
	}

}
