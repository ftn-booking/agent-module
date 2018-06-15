package ftnbooking.agent.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lodging")
public class LodgingController {
	
	@Autowired
	private LodgingService lodgingService;
	@GetMapping("/addLodging")
	public Long testLocation() {
		System.out.println("AAAA");
		Lodging lodging = new Lodging();
		lodging.setName("Hotel Gymnas");
		lodging.setCategory(2);
		lodging.setDescription("Stvarno dobar hotel");
		lodging.setFoodServiceType(FoodServiceType.FULL_BOARD);
		lodging.setHasBathroom(true);
		lodging.setHasKitchen(false);
		lodging.setHasParking(true);
		lodging.setHasTv(false);
		lodging.setHasWifi(true);
		lodging.setNumberOfBeds(5);
		lodging.setType(LodgingType.HOTEL);
		
		Long id = lodgingService.addLodging(lodging);
		
		return id;
	}
}
