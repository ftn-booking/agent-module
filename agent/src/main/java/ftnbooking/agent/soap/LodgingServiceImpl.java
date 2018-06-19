package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LodgingServiceImpl implements LodgingServiceLocal{

	@Autowired
	private LodgingRepository lodgingRepository;
	
	@Override
	public List<Lodging> findByAgentId(Long id) {
		return lodgingRepository.findByAgentId(id);
	}
	
}
