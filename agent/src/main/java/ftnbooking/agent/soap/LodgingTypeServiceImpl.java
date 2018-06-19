package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LodgingTypeServiceImpl implements LodgingTypeService{

	@Autowired
	private LodgingTypeRepository lodgingTypeRepository;
	
	@Override
	public LodgingType findOne(Long id) {
		return lodgingTypeRepository.findById(id).orElse(null);
	}

	@Override
	public List<LodgingType> findAll() {
		return lodgingTypeRepository.findAll();
	}

	@Override
	public LodgingType add(LodgingType input) {
		return lodgingTypeRepository.save(input);
	}

	@Override
	public LodgingType findByName(String name) {
		return lodgingTypeRepository.findByName(name);
	}

}
