package ftnbooking.agent.soap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Lodging")
@Entity
public class Lodging {

	@XmlElement(required = true)
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@Version
	private Long version;

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
	private Double rating;

	@XmlElement(required = true)
	private int numberOfRatings = 0;
	
	@XmlElement(required = true)
	@Min(1)
	private int numberOfBeds;

	@XmlElement(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<FeatureType> featureType;

	@XmlElement(required = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private LodgingType lodgingType;

	@XmlElement(required = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private FoodServiceType foodServiceType;

	@XmlElement(required = true)
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> imagePaths = new ArrayList<String>();

	@XmlElement(required = true)
	@ManyToOne(fetch = FetchType.EAGER)
	private ApplicationUser agent;
	
	public Lodging() {}


	public Lodging(String name, String address, String description, int category, LodgingType lodgingType,
			FoodServiceType foodServiceType, int numberOfBeds, Set<FeatureType> featureType, ApplicationUser agent) {
		this.name = name;
		this.address = address;
		this.description = description;
		this.category = category;
		this.lodgingType = lodgingType;
		this.foodServiceType = foodServiceType;
		this.numberOfBeds = numberOfBeds;
		this.featureType = featureType;
		this.agent = agent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public int getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public ApplicationUser getAgent() {
		return agent;
	}

	public void setAgent(ApplicationUser agent) {
		this.agent = agent;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}

	public void addImagePath(String imagePath) {
		this.imagePaths.add(imagePath);
	}

	public Set<FeatureType> getFeatureType() {
		return featureType;
	}

	public void setFeatureType(Set<FeatureType> featureType) {
		this.featureType = featureType;
	}

	public LodgingType getLodgingType() {
		return lodgingType;
	}

	public void setLodgingType(LodgingType lodgingType) {
		this.lodgingType = lodgingType;
	}

	public FoodServiceType getFoodServiceType() {
		return foodServiceType;
	}

	public void setFoodServiceType(FoodServiceType foodServiceType) {
		this.foodServiceType = foodServiceType;
	}


	@Override
	public String toString() {
		return "Lodging [id=" + id + ", version=" + version + ", name=" + name + ", address=" + address
				+ ", description=" + description + ", category=" + category + ", rating=" + rating + ", numberOfBeds="
				+ numberOfBeds + ", featureType=" + featureType + ", lodgingType=" + lodgingType + ", foodServiceType="
				+ foodServiceType + ", imagePaths=" + imagePaths + ", agent=" + agent + "]";
	}
	
	

}
