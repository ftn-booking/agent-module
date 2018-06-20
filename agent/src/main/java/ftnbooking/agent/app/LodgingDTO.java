package ftnbooking.agent.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.FeatureType;
import ftnbooking.agent.soap.FoodServiceType;
import ftnbooking.agent.soap.FoodServiceTypeRepository;
import ftnbooking.agent.soap.Lodging;
import ftnbooking.agent.soap.LodgingType;

public class LodgingDTO {

	@XmlElement(required = true)
	@Pattern(regexp = "(?U)[\\p{Alpha}\\h]*")
	@NotBlank
	private String name;

	@XmlElement(required = true)
	private String address;

	@XmlElement(required = true)
	@NotBlank
	private String description;

	@XmlElement(required = true)
	@Max(5)
	@Min(0)
	private int category;

	@XmlElement(required = true)
	@Max(5)
	@Min(1)
	private Integer rating;

	@XmlElement(required = true)
	@Min(1)
	private int numberOfBeds;

	@XmlElement(required = true)
	@ManyToMany(cascade = CascadeType.REMOVE)
	private List<Long> featureType;

	@XmlElement(required = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private Long lodgingType;

	@XmlElement(required = true)

	@ManyToOne(fetch = FetchType.EAGER)
	private Long foodServiceType;

	@XmlElement(required = true)
	@ElementCollection
	private List<String> imagePaths = new ArrayList<String>();

	@XmlElement(required = true)
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private String agent;
	
	public LodgingDTO() {
		
	}
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getCategory() {
		return category;
	}



	public void setCategory(int category) {
		this.category = category;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
	}



	public int getNumberOfBeds() {
		return numberOfBeds;
	}



	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}



	public List<Long> getFeatureType() {
		return featureType;
	}



	public void setFeatureType(List<Long> featureType) {
		this.featureType = featureType;
	}



	public Long getLodgingType() {
		return lodgingType;
	}



	public void setLodgingType(Long lodgingType) {
		this.lodgingType = lodgingType;
	}



	public Long getFoodServiceType() {
		return foodServiceType;
	}



	public void setFoodServiceType(Long foodServiceType) {
		this.foodServiceType = foodServiceType;
	}



	public List<String> getImagePaths() {
		return imagePaths;
	}



	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}



	public String getAgent() {
		return agent;
	}



	public void setAgent(String agent) {
		this.agent = agent;
	}

	
	
	@Override
	public String toString() {
		return "LodgingDTO [name=" + name + ", address=" + address + ", description=" + description + ", category="
				+ category + ", rating=" + rating + ", numberOfBeds=" + numberOfBeds + ", featureType=" + featureType
				+ ", lodgingType=" + lodgingType + ", foodServiceType=" + foodServiceType + ", imagePaths=" + imagePaths
				+ ", agent=" + agent + "]";
	}



}
