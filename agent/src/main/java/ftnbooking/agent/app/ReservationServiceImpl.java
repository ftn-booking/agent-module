package ftnbooking.agent.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.Price;
import ftnbooking.agent.soap.Reservation;
import ftnbooking.agent.soap.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationServiceLocal{

	@Autowired
	private ReservationRepository reservationRepository;
	
	
	@Override
	public Reservation findOne(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public List<Reservation> findByLodging(Lodging l) {
		return reservationRepository.findByLodging(l);
	}

	@Override
	public Reservation add(Reservation r) {
		return reservationRepository.save(r);
	}

	@Override
	public boolean validate(Reservation r) { //silly me
		List<Reservation> reservations = reservationRepository
				.findByLodgingAndToDateGreaterThanAndFromDateLessThan(r.getLodging(), r.getFromDate(), r.getToDate());
		if(reservations == null || reservations.isEmpty())
			// There are no other prices for this lodging at specified time
			return true;
		return false;
	}

	@Override
	public boolean validate(Price p) {
		List<Reservation> reservations = reservationRepository.findByToDateGreaterThanAndFromDateLessThan(p.getFromDate(), p.getToDate());
		if(reservations.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Reservation r) {
		reservationRepository.delete(r);
		return true;
	}
	
}
