package ftnbooking.agent.app;

import java.util.List;

import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.Price;

public interface PriceServiceLocal {

	Price addPrice(Price p);
	
	Price findOne(Long id);
	
	List<Price> findByLodging(Lodging l);
	
	boolean validate(Price p);
	
}
