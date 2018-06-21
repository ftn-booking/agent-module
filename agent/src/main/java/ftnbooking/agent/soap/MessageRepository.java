package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByUser(ApplicationUser user);
	
	List<Message> findByReservation_Lodging_Agent(ApplicationUser user);
	
	List<Message> findByReservation(Reservation reservation);
}
