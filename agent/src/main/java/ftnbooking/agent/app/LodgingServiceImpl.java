package ftnbooking.agent.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.LodgingRepository;
import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.Price;
import ftnbooking.agent.soap.PriceRepository;
import ftnbooking.agent.soap.Reservation;
import ftnbooking.agent.soap.ReservationRepository;

@Service
public class LodgingServiceImpl implements LodgingServiceLocal{

	@Autowired
	private LodgingRepository lodgingRepository;
	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private PriceRepository priceRepository;
	
	@Override
	public List<Lodging> findByAgentId(Long id) {
		return lodgingRepository.findByAgentId(id);
	}
	
	@Override
	public Lodging add(Lodging l) {
		Long a = lodgingService.addLodging(l);
		l.setId(a);
		System.out.println(l);
		return lodgingRepository.save(l);
	}

	@Override
	public Lodging findOne(Long id) {
		return lodgingRepository.findById(id).orElse(null);
	}

	@Override
	public void synchronize(ApplicationUser user) {
		List<Lodging> lodgings = lodgingService.synchronizeLodging(user);
		List<Reservation> reservations = lodgingService.synchronizeReservation(user);
		List<Price> prices = lodgingService.synchronizePrice(user);
		lodgingRepository.deleteAll();
		lodgingRepository.saveAll(lodgings);
		reservationRepository.deleteAll();
		reservationRepository.saveAll(reservations);
		priceRepository.deleteAll();
		priceRepository.saveAll(prices);
	}
	
	
}
