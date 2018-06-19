package ftnbooking.agent.soap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodServiceRepository extends JpaRepository<FoodServiceType, Long>{

	FoodServiceType findByName(String name);

}
