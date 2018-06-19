package ftnbooking.agent.soap;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LodgingTypeRepository extends JpaRepository<LodgingType, Long> {

<<<<<<< Updated upstream
=======
	LodgingType findByName(String name);
	
>>>>>>> Stashed changes
}
