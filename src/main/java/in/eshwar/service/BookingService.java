package in.eshwar.service;

import in.eshwar.request.Passanger;
import in.eshwar.responce.Ticket;

public interface BookingService {

	
	public Ticket bookTicket(Passanger passanger);
	
	public Ticket geTicket(Integer ticketNumber);
}
