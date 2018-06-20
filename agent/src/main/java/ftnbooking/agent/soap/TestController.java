package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	@GetMapping("/addLodging")
	public Long testLocation(Lodging l) {
		System.out.println("AAAA");
		/*LodgingType lodgingType1 = new LodgingType("HOTEL");
		lodgingTypeRepository.save(lodgingType1);
		
		FeatureType featureType1 = new FeatureType("hasTV");
		FeatureType featureType2 = new FeatureType("hasWiFi");
		FeatureType featureType3 = new FeatureType("hasParking");
		featureTypeRepository.save(featureType1);
		featureTypeRepository.save(featureType2);
		featureTypeRepository.save(featureType3);
		List<FeatureType> features = featureTypeRepository.findAll();
		*/
		ApplicationUser user3 = new ApplicationUser("han@me", "qweqwe", "Han", "Solo", "Corellia", null);

		Lodging lodging = new Lodging("Lodging",
				"Hawaii",
				"Test lodging 1",
				4,
				null,//lodgingType1,
				null, //foodServiceType1
				2,
				null,//features,
				user3);
		lodging.addImagePath("img/placeholder.png");
		lodging.addImagePath("img/placeholder.png");
		lodging.addImagePath("img/placeholder.png");
		user3.setUserType(ApplicationUserType.AGENT);
		applicationUserRepository.save(user3);
		lodging.setAgent(user3);
		Long id = lodgingService.addLodging(lodging);
		return 0L;
	}
	
	@GetMapping("/fst")
	public List<FoodServiceType> testFoodServiceType() {
		List<FoodServiceType> list = lodgingService.synchronizeFoodServiceType();
		return list;
	}
	
	@GetMapping("/users")
	public List<ApplicationUser> testApplicationUser() {
		List<ApplicationUser> list = lodgingService.synchronizeApplicationUser();
		return list;
	}
	
	@GetMapping("/lodgings")
	public List<Lodging> testLodgings() {
		ApplicationUser arg0 = applicationUserRepository.findByEmail("han@me");
		List<Lodging> list = lodgingService.synchronizeLodging(arg0);
		return list;
	}
}
