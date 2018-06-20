package ftnbooking.agent.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.Price;
import ftnbooking.agent.soap.PriceRepository;

@Service
public class PriceServiceLocalImpl implements PriceServiceLocal{

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Price addPrice(Price p) {
		return priceRepository.save(p);
	}

	@Override
	public Price findOne(Long id) {
		return priceRepository.findById(id).orElse(null);
	}

	@Override
	public List<Price> findByLodging(Lodging l) {
		return priceRepository.findByLodging(l);
	}
	
	
}
