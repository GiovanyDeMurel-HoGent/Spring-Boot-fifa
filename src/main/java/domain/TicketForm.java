package domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import validator.ValidEmail;

public class TicketForm {

//	@Pattern(regexp = "[0-9]+" /*, message="{UnexpectedTypeException}"*/)
	@NotNull(message="{ticketform.empty}")
	@NumberFormat(style=Style.NUMBER)
	@Min(value=1, message="{ticketform.tickets.range}")
	@Max(value=25, message="{ticketform.tickets.range}")
	private int tickets;
	
	@NotEmpty(message="{ticketform.empty}")
	@ValidEmail(message="{ticketform.email.valid}")
	private String email;
	
	@NotNull(message="{ticketform.empty}")
	@NumberFormat(style=Style.NUMBER)
	@Min(0)
	private int voetbalCode1;
	@NotNull(message="{ticketform.empty}")
	@NumberFormat(style=Style.NUMBER)
	@Min(0)
	private int voetbalCode2;
	
	private int availableTickets;
	
	
	public int getAvailableTickets() {
		return availableTickets;
	}
	public void setAvailableTickets(int availableTickets) {
		this.availableTickets = availableTickets;
	}
	public int getTickets() {
		return tickets;
	}
	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getVoetbalCode1() {
		return voetbalCode1;
	}
	public void setVoetbalCode1(int voetbalCode1) {
		this.voetbalCode1 = voetbalCode1;
	}
	public int getVoetbalCode2() {
		return voetbalCode2;
	}
	public void setVoetbalCode2(int voetbalCode2) {
		this.voetbalCode2 = voetbalCode2;
	}
	
}
