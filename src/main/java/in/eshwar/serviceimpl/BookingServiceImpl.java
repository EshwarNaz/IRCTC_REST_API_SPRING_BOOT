package in.eshwar.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.eshwar.request.Passanger;
import in.eshwar.responce.Ticket;
import in.eshwar.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	private Map<Integer, Ticket> ticketMap = new HashMap();
	private Integer ticketNumber = 1;

	public Ticket bookTicket(Passanger passanger) {

		Ticket t = new Ticket();
		BeanUtils.copyProperties(passanger, t);
		t.setTicketNumber(ticketNumber);
		t.setStatus("Confirmed");
		t.setTicketCost(300.00);
		ticketMap.put(ticketNumber, t);
		ticketNumber++;
		return t;
	}

	public Ticket geTicket(Integer ticketNumber) {
		if (ticketMap.containsKey(ticketNumber)) {
			return ticketMap.get(ticketNumber);
		}
		return null;
	}
}
