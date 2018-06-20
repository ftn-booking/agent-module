package ftnbooking.agent.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftnbooking.agent.soap.ApplicationUserRepository;
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
		System.out.println(l.toString());	
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
	
	
}
