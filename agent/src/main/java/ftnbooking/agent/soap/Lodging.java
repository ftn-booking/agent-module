package ftnbooking.agent.soap;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

	@Id
	@GeneratedValue
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@Version
	private Long version;

	@XmlElement(required = true)
	@Pattern(regexp = "(?U)[\\p{Alpha}\\h]*")
	@NotBlank
	private String name;

	@XmlElement(required = true)
	@NotBlank
	private String description;

	@XmlElement(required = true)
	@Max(5)
	@Min(0)
	private int category;

	@XmlElement(required = true)
	@Enumerated(EnumType.STRING)
	private LodgingType type;

	@XmlElement(required = true)
	@Max(5)
	@Min(1)
	private Integer rating;

	@XmlElement(required = true)
	@Min(1)
	private int numberOfBeds;

	@XmlElement(required = true)
	private boolean hasParking;
	
	@XmlElement(required = true)
	private boolean hasWifi;
	
	@XmlElement(required = true)
	private boolean hasTv;
	
	@XmlElement(required = true)
	private boolean hasKitchen;
	
	@XmlElement(required = true)
	private boolean hasBathroom;

	@XmlElement(required = true)
	@Enumerated(EnumType.STRING)
	private FoodServiceType foodServiceType;

	public Lodging() {}

	public Lodging(String name,
			String description,
			int category,
			LodgingType type,
			int numberOfBeds,
			boolean hasParking,
			boolean hasWifi,
			boolean hasTv,
			boolean hasKitchen,
			boolean hasBathroom,
			FoodServiceType foodServiceType) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.type = type;
		this.numberOfBeds = numberOfBeds;
		this.hasParking = hasParking;
		this.hasWifi = hasWifi;
		this.hasTv = hasTv;
		this.hasKitchen = hasKitchen;
		this.hasBathroom = hasBathroom;
		this.foodServiceType = foodServiceType;
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

	public LodgingType getType() {
		return type;
	}

	public void setType(LodgingType type) {
		this.type = type;
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

	public boolean isHasParking() {
		return hasParking;
	}

	public void setHasParking(boolean hasParking) {
		this.hasParking = hasParking;
	}

	public boolean isHasWifi() {
		return hasWifi;
	}

	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}

	public boolean isHasTv() {
		return hasTv;
	}

	public void setHasTv(boolean hasTv) {
		this.hasTv = hasTv;
	}

	public boolean isHasKitchen() {
		return hasKitchen;
	}

	public void setHasKitchen(boolean hasKitchen) {
		this.hasKitchen = hasKitchen;
	}

	public boolean isHasBathroom() {
		return hasBathroom;
	}

	public void setHasBathroom(boolean hasBathroom) {
		this.hasBathroom = hasBathroom;
	}

	public FoodServiceType getFoodServiceType() {
		return foodServiceType;
	}

	public void setFoodServiceType(FoodServiceType foodServiceType) {
		this.foodServiceType = foodServiceType;
	}



}
