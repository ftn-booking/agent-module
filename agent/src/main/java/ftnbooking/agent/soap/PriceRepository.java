package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRepository extends JpaRepository<Price, Long> {
	
	List<Price> findByLodging(Lodging lodging);
	
	List<Price> findByLodgingAndToDateGreaterThanAndFromDateLessThan(Lodging lodging,
			long currentFromDate,
			long currentToDate);
}
