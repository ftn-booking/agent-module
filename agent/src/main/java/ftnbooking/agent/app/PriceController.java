package ftnbooking.agent.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.Price;
import ftnbooking.agent.soap.Reservation;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	private PriceServiceLocal priceServiceLocal;
	@Autowired
	private LodgingServiceLocal lodgingServiceLocal;
	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private ReservationServiceLocal reservationServiceLocal;
	
	@PostMapping
	public ResponseEntity<?> addPric(@RequestBody PriceDTO price) {
		Price p = new Price();
		p.setPricePerDay(price.getPricePerDay());
		p.setFromDate(price.getFromDate().getTime());
		p.setToDate(price.getToDate().getTime());
		p.setLodging(lodgingServiceLocal.findOne(price.getLodging()));
		if(!priceServiceLocal.validate(p))
			return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
		p.setId(lodgingService.addPrice(p));
		return new ResponseEntity<>(priceServiceLocal.addPrice(p), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPrices(@PathVariable Long id){
		List<Price> prices = priceServiceLocal.findByLodging(lodgingServiceLocal.findOne(id));
		return new ResponseEntity<>(prices,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Price p = priceServiceLocal.findOne(id);
		if(reservationServiceLocal.validate(p)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
