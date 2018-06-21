package ftnbooking.agent.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.Message;
import ftnbooking.agent.soap.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	private MessageService messageService;
	@Autowired
	private ReservationServiceLocal reservationService;
	@Autowired
	private LodgingService lodgingService;

	@GetMapping("/{id}")
	public ResponseEntity<?> getMessages(@PathVariable Long id){
		return new ResponseEntity<>(messageService.findByReservation(reservationService.findOne(id)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> sendMessage(@RequestBody MessageDTO mDTO){
		System.out.println(mDTO.toString());
		Message msg = new Message();
		msg.setContent(mDTO.getContent());
		msg.setReservation(reservationService.findOne(mDTO.getReservation()));
		msg.setUser(msg.getReservation().getUser());
		msg.setUserSent(false);
		msg.setId(lodgingService.sendMessage(msg));
		return new ResponseEntity<>(messageService.add(msg), HttpStatus.OK);
	}

}
