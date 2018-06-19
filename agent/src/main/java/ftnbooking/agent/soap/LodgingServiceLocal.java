package ftnbooking.agent.soap;

import java.util.List;

public interface LodgingServiceLocal {

	List<Lodging> findByAgentId(Long id);
	
}
