package ftnbooking.agent;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ftnbooking.agent.soap.FeatureType;
import ftnbooking.agent.soap.FeatureTypeService;
import ftnbooking.agent.soap.FoodServiceType;
import ftnbooking.agent.soap.FoodServiceTypeService;
import ftnbooking.agent.soap.LodgingService;
import ftnbooking.agent.soap.LodgingType;
import ftnbooking.agent.soap.LodgingTypeService;

@Component
public class TestData {

	@Autowired
	private LodgingService lodgingService;
	//@Autowired
	//private ReservationService reservationService;
	@Autowired
	private LodgingTypeService lodgingTypeService;
	@Autowired
	private FeatureTypeService featureTypeService;
	@Autowired
	private FoodServiceTypeService foodServiceTypeService;

	@PostConstruct
	private void init() {
		LodgingType lodgingType1 = new LodgingType("HOTEL");
		LodgingType lodgingType2 = new LodgingType("B & B");
		LodgingType lodgingType3 = new LodgingType("APARTMENT");
		lodgingTypeService.add(lodgingType1);
		lodgingTypeService.add(lodgingType2);
		lodgingTypeService.add(lodgingType3);
		
		FeatureType featureType1 = new FeatureType("hasTV");
		FeatureType featureType2 = new FeatureType("hasWiFi");
		FeatureType featureType3 = new FeatureType("hasParking");
		featureTypeService.add(featureType1);
		featureTypeService.add(featureType2);
		featureTypeService.add(featureType3);
		
		FoodServiceType f1 = new FoodServiceType("Breakfast");
		FoodServiceType f2 = new FoodServiceType("Half Board");
		FoodServiceType f3 = new FoodServiceType("Full Board");
		foodServiceTypeService.add(f1);
		foodServiceTypeService.add(f2);
		foodServiceTypeService.add(f3);
		
	}
	
}
