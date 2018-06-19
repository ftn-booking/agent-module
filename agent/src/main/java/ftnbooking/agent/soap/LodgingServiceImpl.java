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

	@Override
	public Lodging add(Lodging l) {
		return lodgingRepository.save(l);
	}

	@Override
	public Lodging findOne(Long id) {
		return lodgingRepository.findById(id).orElse(null);
	}
	
}
