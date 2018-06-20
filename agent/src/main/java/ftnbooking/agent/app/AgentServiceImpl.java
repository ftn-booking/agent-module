package ftnbooking.agent.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.ApplicationUserRepository;

@Service
public class AgentServiceImpl implements AgentServiceLocal{

	@Autowired
	private ApplicationUserRepository agentRepository;
	
	@Override
	public ApplicationUser add(ApplicationUser user) {
		return agentRepository.save(user);
	}

	@Override
	public ApplicationUser findByEmail(String email) {
		return agentRepository.findByEmail(email);
	}

	@Override
	public ApplicationUser findOne(Long id) {
		return agentRepository.findById(id).orElse(null);
	}

}
