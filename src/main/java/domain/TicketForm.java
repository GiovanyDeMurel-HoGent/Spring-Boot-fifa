package domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import validator.ValidEmail;

public class TicketForm {

	@NotNull
	@Min(1)
	@Max(25)
	private int tickets;
	
	@ValidEmail
	private String email;
	
	@NotNull
	@Min(0)
	private int voetbalCode1;
	@NotNull
	@Min(0)
	private int voetbalCode2;
	
	
	
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
