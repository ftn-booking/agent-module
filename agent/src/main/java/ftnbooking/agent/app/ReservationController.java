package ftnbooking.agent.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.Reservation;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationServiceLocal reservationServiceLocal;
	
	@Autowired
	private AgentServiceLocal userServiceLocal;
	
	@Autowired
	private LodgingServiceLocal lodgingServiceLocal;
	
	@Autowired
	private LodgingService lodgingService;
	
	@PostMapping
	public ResponseEntity<?> addReservation(@RequestBody ReservationDTO rDTO){
		Reservation r = new Reservation();
		r.setUser(userServiceLocal.findByEmail(rDTO.getUser()));
		r.setFromDate(rDTO.getFromDate().getTime());
		r.setToDate(rDTO.getToDate().getTime());
		r.setLodging(lodgingServiceLocal.findOne(rDTO.getLodging()));
		r.setRating(rDTO.getRating());
		r.setRating(4); //XXX: temporary
		r.setId(lodgingService.reserveLodging(r));
		return new ResponseEntity<>(reservationServiceLocal.add(r), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getMyReservations(@PathVariable Long id){
		return new ResponseEntity<>(reservationServiceLocal.findByLodging(lodgingServiceLocal.findOne(id)),HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<?> approve(@PathVariable Long id){
		Reservation r = reservationServiceLocal.findOne(id);
		r.setApproved(true); 
		Long res = lodgingService.realizeReservation(r);
		if(id == res) {
			reservationServiceLocal.add(r); 
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
