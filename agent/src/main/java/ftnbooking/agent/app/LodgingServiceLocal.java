package ftnbooking.agent.app;

import java.util.List;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.Lodging;

public interface LodgingServiceLocal {

	List<Lodging> findByAgentId(Long id);
	
	Lodging add(Lodging l);
	
	Lodging findOne(Long id);

	void synchronize(ApplicationUser user);

	Lodging delete(Long id);
}
