package ftnbooking.agent.soap;

import java.util.List;

public interface FoodServiceTypeService {

	FoodServiceType findOne(Long id);
	
	FoodServiceType add(FoodServiceType foodServiceType);
	
	List<FoodServiceType> findAll();

	FoodServiceType findByName(String name);
	
	void deleteAll();
	
	void addAll(List<FoodServiceType> list);
}
