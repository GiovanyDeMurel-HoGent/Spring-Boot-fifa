package domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TicketForm {

	@NotNull
	@Min(1)
	@Max(25)
	private int tickets;
	
	private String email;
	private String voetbalCode1;
	private String voetbalCode2;
	
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
	public String getVoetbalCode1() {
		return voetbalCode1;
	}
	public void setVoetbalCode1(String voetbalCode1) {
		this.voetbalCode1 = voetbalCode1;
	}
	public String getVoetbalCode2() {
		return voetbalCode2;
	}
	public void setVoetbalCode2(String voetbalCode2) {
		this.voetbalCode2 = voetbalCode2;
	}
	
}
