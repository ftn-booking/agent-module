package ftnbooking.agent.soap;

import java.util.List;

public interface FeatureTypeService {
	FeatureType findOne(Long id);

	List<FeatureType> findAll();

	FeatureType add(FeatureType input);

	FeatureType findByName(String name);
}
