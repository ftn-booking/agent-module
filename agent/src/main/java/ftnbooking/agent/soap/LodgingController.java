<<<<<<< Updated upstream:agent/src/main/java/ftnbooking/agent/soap/LodgingController.java
package ftnbooking.agent.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lodging")
public class LodgingController {
	
	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private LodgingServiceLocal lodgingServiceLocal;
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	@Autowired
	private LodgingTypeService lodgingTypeService;
	@Autowired
	private FeatureTypeService featureTypeService;
	@Autowired
	private FoodServiceTypeService foodServiceTypeService;
	
	@GetMapping("/agent/{id}")
		public ResponseEntity<?> getMyLodgings(@PathVariable Long id){
		List<Lodging> lodgings = lodgingServiceLocal.findByAgentId(id);
		return new ResponseEntity<>(lodgings, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLodging(@PathVariable Long id){
	Lodging lodging = lodgingServiceLocal.findOne(id);
	return new ResponseEntity<>(lodging, HttpStatus.OK);
}
	
	@PostMapping("/add")
	public ResponseEntity<?> addLodging(@RequestBody Lodging l){
//		System.out.println(l.toString());	
		return new ResponseEntity<>(lodgingServiceLocal.add(l), HttpStatus.OK);
	}
	
	@GetMapping("/food/{id}")
	public ResponseEntity<?> getLodgingMeal(@PathVariable Long id){
		return new ResponseEntity<>(foodServiceTypeService.findOne(id),HttpStatus.OK);
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity<?> getLodgingType(@PathVariable Long id){
		return new ResponseEntity<>(lodgingTypeService.findOne(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/feature/{id}")
	public ResponseEntity<?> getLodgingService(@PathVariable Long id){
		return new ResponseEntity<>(featureTypeService.findOne(id),HttpStatus.OK);
	}
	
	@GetMapping("/getLodgingTypes")
	public ResponseEntity<?> getLodgingTypes(){
		return new ResponseEntity<>(lodgingTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getFeatureTypes")
	public ResponseEntity<?> getFeatureTypes(){
		return new ResponseEntity<>(featureTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getFoodServiceTypes")
	public ResponseEntity<?> getFoodServiceTypes(){
		List<FoodServiceType> fst = foodServiceTypeService.findAll();
		System.out.println(fst.size());
		return new ResponseEntity<>(fst, HttpStatus.OK);
	}
	
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
		
		return 0L;
	}
}
=======
package ftnbooking.agent.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.ApplicationUserRepository;
import ftnbooking.agent.soap.FeatureType;
import ftnbooking.agent.soap.FeatureTypeService;
import ftnbooking.agent.soap.FoodServiceType;
import ftnbooking.agent.soap.FoodServiceTypeRepository;
import ftnbooking.agent.soap.FoodServiceTypeService;
import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.LodgingTypeService;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lodging")
public class LodgingController {
	
	@Autowired
	private LodgingService lodgingService;
	@Autowired
	private LodgingServiceLocal lodgingServiceLocal;
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	@Autowired
	private LodgingTypeService lodgingTypeService;
	@Autowired
	private FeatureTypeService featureTypeService;
	@Autowired
	private FoodServiceTypeService foodServiceTypeService;
	@Autowired
	private AgentServiceLocal agentService;
	
	@GetMapping("/agent/{id}")
		public ResponseEntity<?> getMyLodgings(@PathVariable Long id){
		List<Lodging> lodgings = lodgingServiceLocal.findByAgentId(id);
		return new ResponseEntity<>(lodgings, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLodging(@PathVariable Long id){
		Lodging lodging = lodgingServiceLocal.findOne(id);
		return new ResponseEntity<>(lodging, HttpStatus.OK);
	}
	
	public List<FeatureType> features(List<Long> feature) {
		List<FeatureType> list = new ArrayList<>();
		if(feature == null) {
			return new ArrayList<>();
		}
		for(int i = 0; i<feature.size(); i++) {
			list.add(featureTypeService.findOne(feature.get(i)));
		}
		return list;
	}
	
	public Lodging convert(LodgingDTO l1) {
		Lodging l = new Lodging();
		l.setAddress(l1.getAddress());
		l.setAgent(agentService.findByEmail(l1.getAgent()));
		l.setCategory(l1.getCategory());
		l.setDescription(l1.getDescription());
		l.setFoodServiceType(foodServiceTypeService.findOne(l1.getFoodServiceType()));
		l.setLodgingType(lodgingTypeService.findOne(l1.getLodgingType()));
		l.setImagePaths(l1.getImagePaths());
		l.setName(l1.getName());
		l.setNumberOfBeds(l1.getNumberOfBeds());
		l.setFeatureType(features(l1.getFeatureType()));
		l.setImagePaths(l1.getImagePaths());
		return l;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addLodging(@RequestBody LodgingDTO l1){
		System.out.println(l1);
		Lodging l = lodgingServiceLocal.add(convert(l1));
		System.out.println(l);
		return new ResponseEntity<>(l, HttpStatus.OK);
	}
	
	@GetMapping("/food/{id}")
	public ResponseEntity<?> getLodgingMeal(@PathVariable Long id){
		return new ResponseEntity<>(foodServiceTypeService.findOne(id),HttpStatus.OK);
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity<?> getLodgingType(@PathVariable Long id){
		return new ResponseEntity<>(lodgingTypeService.findOne(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/feature/{id}")
	public ResponseEntity<?> getLodgingService(@PathVariable Long id){
		return new ResponseEntity<>(featureTypeService.findOne(id),HttpStatus.OK);
	}
	
	@GetMapping("/getLodgingTypes")
	public ResponseEntity<?> getLodgingTypes(){
		return new ResponseEntity<>(lodgingTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getFeatureTypes")
	public ResponseEntity<?> getFeatureTypes(){
		return new ResponseEntity<>(featureTypeService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/getFoodServiceTypes")
	public ResponseEntity<?> getFoodServiceTypes(){
		List<FoodServiceType> fst = foodServiceTypeService.findAll();
		System.out.println(fst.size());
		return new ResponseEntity<>(fst, HttpStatus.OK);
	}
	
	
}
>>>>>>> Stashed changes:agent/src/main/java/ftnbooking/agent/app/LodgingController.java
