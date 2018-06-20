package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageRepository;
	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	@Override
	public List<Message> findByUser(ApplicationUser user) {
		return messageRepository.findByUser(user);
	}

	@Override
	public List<Message> findByAgent(ApplicationUser user) {
		return messageRepository.findByReservation_Lodging_Agent(user);
	}

	@Override
	public Message add(Message input) {
		return messageRepository.save(input);
	}

}
