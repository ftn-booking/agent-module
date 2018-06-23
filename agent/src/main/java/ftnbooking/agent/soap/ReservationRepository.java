package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	List<Reservation> findByUser(ApplicationUser user);
	List<Reservation> findByLodgingAndToDateGreaterThanAndFromDateLessThan(Lodging lodging,
			long currentFromDate,
			long currentToDate);
	List<Reservation> findByLodging(Lodging lodging);
	List<Reservation> findByToDateGreaterThanAndFromDateLessThan(long currentFromDate, long currentToDate);
}
