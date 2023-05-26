package in.eshwar.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.eshwar.request.Passanger;
import in.eshwar.responce.Ticket;
import in.eshwar.service.BookingService;

@RestController
public class BookingRestContoller {

	@Autowired
	private BookingService bookingService;

	@PostMapping(value = "/ticket", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passanger passanger) {
		Ticket ticket = bookingService.bookTicket(passanger);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}

	@GetMapping(value = "/get/{ticketNumber}", produces = { "application/json" })
	public Ticket getTicket(@PathVariable Integer ticketNumber) {
		return bookingService.geTicket(ticketNumber);
	}

}
