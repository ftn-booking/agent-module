package ftnbooking.agent.soap;

import java.util.List;


public interface MessageService {
	
	public List<Message> findAll();
	
	public List<Message> findByUser(ApplicationUser user);
	
	public List<Message> findByAgent(ApplicationUser user);
	
	public Message add(Message input);
}
