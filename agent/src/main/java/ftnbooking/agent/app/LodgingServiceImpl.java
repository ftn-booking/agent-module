package ftnbooking.agent.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.LodgingRepository;
import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.Message;
import ftnbooking.agent.soap.MessageRepository;
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
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public List<Lodging> findByAgentId(Long id) {
		return lodgingRepository.findByAgentId(id);
	}
	
	@Override
	public Lodging add(Lodging l) {
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
		List<Message> messages = lodgingService.synchronizeMessage(user);
		//System.out.println(lodgings);
		//priceRepository.deleteAll();
		messageRepository.deleteAll();
		//reservationRepository.deleteAll();
		//lodgingRepository.deleteAll();
		lodgingRepository.saveAll(lodgings);
		
		reservationRepository.saveAll(reservations);
		
		priceRepository.saveAll(prices);

		messageRepository.saveAll(messages);
	}

	@Override
	public Lodging delete(Long id) {
		Lodging l = findOne(id);
		if (l == null) {
			throw new IllegalArgumentException("Tried to delete non existant lodging");
		}
		lodgingRepository.delete(l);
		return l;
	}
	
	
}
