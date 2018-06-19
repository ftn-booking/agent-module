package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sun.mail.iap.Response;

@RestController
@RequestMapping("/lodging")
public class LodgingController {
	
	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	@Autowired
	private LodgingTypeService lodgingTypeService;
	@Autowired
	private FeatureTypeService featureTypeService;
	@Autowired
	private LodgingServiceLocal lsl;
	
	@GetMapping("/{id}")
		public ResponseEntity<?> getMyLodgings(@PathVariable Long id){
		List<Lodging> lodgings = lsl.findByAgentId(id);
		return new ResponseEntity<>(lodgings, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addLodging(Lodging l){
		lodgingService.addLodging(l);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getLodgingTypes")
	public ResponseEntity<?> getLodgingTypes(){
		List<LodgingType> lt = lodgingTypeService.findAll();
		System.out.println(lt.size());
		return new ResponseEntity<>(lt,HttpStatus.OK);
	}
	
	@GetMapping("/getFeatureTypes")
	public ResponseEntity<?> getFeatureTypes(){
		List<FeatureType> ft = featureTypeService.findAll();
		System.out.println(ft.size());
		return new ResponseEntity<>(ft,HttpStatus.OK);
	}
	
	@GetMapping("/addLodging")
	public Long testLocation() {
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
		
		return id;
	}
}
