package ftnbooking.agent.app;

import java.util.List;

import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.Reservation;

public interface ReservationServiceLocal {

	Reservation findOne(Long id);
	
	List<Reservation> findByLodging(Lodging l);
	
	Reservation add(Reservation r);
	
	boolean validate(Reservation r);
}
