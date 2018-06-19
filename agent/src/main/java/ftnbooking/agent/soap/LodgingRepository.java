package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LodgingRepository extends JpaRepository<Lodging, Long>{
	
	List<Lodging> findByAgentId(Long id);
	
}
