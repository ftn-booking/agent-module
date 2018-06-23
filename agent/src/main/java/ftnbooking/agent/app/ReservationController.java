package ftnbooking.agent.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.ApplicationUserType;
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
		ApplicationUser appUser = userServiceLocal.findByEmail(rDTO.getUser());
		if(appUser.getUserType().equals(ApplicationUserType.VISITOR)) {
			r.setUser(appUser);
		}
		else if(appUser.equals(lodgingServiceLocal.findOne(rDTO.getLodging()).getAgent())) {
			r.setUser(appUser);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		r.setFromDate(rDTO.getFromDate().getTime());
		r.setToDate(rDTO.getToDate().getTime());
		r.setLodging(lodgingServiceLocal.findOne(rDTO.getLodging()));
		r.setRating(rDTO.getRating());
		r.setRating(null); //XXX: temporary
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Reservation r = reservationServiceLocal.findOne(id);
		if(!r.isApproved() && r.getLodging().getAgent().equals(r.getUser())) {
			lodgingService.deleteReservation(r);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
