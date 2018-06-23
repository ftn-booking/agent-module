package ftnbooking.agent.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.ApplicationUserRepository;
import ftnbooking.agent.soap.ApplicationUserType;
import ftnbooking.agent.soap.FeatureType;
import ftnbooking.agent.soap.FeatureTypeService;
import ftnbooking.agent.soap.FoodServiceType;
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
		System.out.println("LODGINGSI");
		//System.out.println(lodgings);s
		return new ResponseEntity<>(lodgings, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getLodging(@PathVariable Long id){
		Lodging lodging = lodgingServiceLocal.findOne(id);
		return new ResponseEntity<>(lodging, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateLodging(@PathVariable Long id, @RequestBody LodgingDTO lodgingDTO){
		Lodging l = lodgingServiceLocal.findOne(id);
		l.setAddress(lodgingDTO.getAddress());
		l.setName(lodgingDTO.getName());
		l.setDescription(lodgingDTO.getDescription());
		l.setNumberOfBeds(lodgingDTO.getNumberOfBeds());
		l.setFoodServiceType(foodServiceTypeService.findOne(lodgingDTO.getFoodServiceType()));
		l.setLodgingType(lodgingTypeService.findOne(lodgingDTO.getLodgingType()));
		l.setFeatureType(features(lodgingDTO.getFeatureType()));
		/*TODO: UPDATE*/
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteLodging(@PathVariable Long id){
		System.err.println(id);
		Lodging l = lodgingServiceLocal.findOne(id);
		boolean deleted = lodgingService.deleteLodging(l);
		if (deleted) {
			return new ResponseEntity<>(lodgingServiceLocal.delete(id), HttpStatus.OK);			
		}
		return new ResponseEntity<>("Could not delete lodging",HttpStatus.BAD_REQUEST);
	}
	
	public Set<FeatureType> features(List<Long> feature) {
		Set<FeatureType> list = new HashSet<>();
		if(feature == null) {
			return new HashSet<>();
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
		l.setRating(l1.getRating());
		return l;
	}
	
	@PostMapping("/synchronize/{email}") 
	public void synchronize(@PathVariable String email){
		System.out.println(email);
		ApplicationUser user = applicationUserRepository.findByEmail(email);
		lodgingServiceLocal.synchronize(user);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addLodging(@RequestBody LodgingDTO l1){
		System.out.println(l1);
		
		Lodging l = convert(l1);
		l.setId(lodgingService.addLodging(l));
		lodgingServiceLocal.add(l);
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