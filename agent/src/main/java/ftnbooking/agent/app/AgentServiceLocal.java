package ftnbooking.agent.app;

import ftnbooking.agent.soap.ApplicationUser;

public interface AgentServiceLocal {

	ApplicationUser add(ApplicationUser user);
	
	ApplicationUser findByEmail(String email);
	
	ApplicationUser findOne(Long id);
}
