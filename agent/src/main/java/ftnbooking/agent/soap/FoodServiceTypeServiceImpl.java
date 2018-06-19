package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceTypeServiceImpl implements FoodServiceTypeService{

	@Autowired
	private FoodServiceRepository foodServiceRepository;
	
	@Override
	public FoodServiceType findOne(Long id) {
		return foodServiceRepository.findById(id).orElse(null);
	}

	@Override
	public FoodServiceType add(FoodServiceType foodServiceType) {
		return foodServiceRepository.save(foodServiceType);
	}

	@Override
	public List<FoodServiceType> findAll() {
		return foodServiceRepository.findAll();
	}

	@Override
	public FoodServiceType findByName(String name) {
		return foodServiceRepository.findByName(name);
	}

}
