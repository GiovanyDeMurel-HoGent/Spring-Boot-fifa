package domain;

//Aantal tickets beschikbaar per wedstrijd
public class WedstrijdTicket {

    private Wedstrijd wedstrijd; 

    private int tickets; //aantal tickets beschikbaar

    public WedstrijdTicket(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
        //this.tickets = wedstrijd.getTickets();
    }

    public int getTickets() {
        return tickets;
    }
    
    //We willen 'aantal' tickets kopen
    public int ticketsKopen(int aantal) {
        if (aantal <= 0) {
            return -1;
        }
        
        //Nog voldoende tickets
        if (tickets >= aantal) {
            tickets -= aantal;
            return aantal;
        }

        //Niet meer voldoende tickets
        int gekocht = tickets;
        tickets = 0;
        return gekocht;
    }

    public boolean uitverkocht() {
        return tickets == 0;
    }

	public void setConfirmPassword(Object object) {
		// TODO Auto-generated method stub
		
	}
}
