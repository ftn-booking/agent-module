package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureTypeServiceImpl implements FeatureTypeService{

	@Autowired
	private FeatureTypeRepository featureTypeRepository;
	
	@Override
	public FeatureType findOne(Long id) {
		return featureTypeRepository.findById(id).orElse(null);
	}

	@Override
	public List<FeatureType> findAll() {
		return featureTypeRepository.findAll();
	}

	@Override
	public FeatureType add(FeatureType input) {
		return featureTypeRepository.save(input);
	}

	@Override
	public FeatureType findByName(String name) {
		return featureTypeRepository.findByName(name);
	}

}
