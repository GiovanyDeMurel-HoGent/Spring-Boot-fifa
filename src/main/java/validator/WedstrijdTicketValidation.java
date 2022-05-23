package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import domain.WedstrijdTicket;

public class WedstrijdTicketValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WedstrijdTicket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WedstrijdTicket WedstrijdTicket = (WedstrijdTicket) target;
		
		//String email = WedstrijdTicket.getEmail();
		
	}

}