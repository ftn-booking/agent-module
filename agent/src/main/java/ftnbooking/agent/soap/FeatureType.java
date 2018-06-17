package ftnbooking.agent.soap;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * breakfast, fullboard, hasTv, hasParking...
 * */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
@XmlRootElement(name = "FeatureType")
@Entity
public class FeatureType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@XmlElement(required = true)
	private String name;
	
	@XmlElement(required = true)
	private boolean active;
	
	public FeatureType() {
		
	}

	public FeatureType(String name) {
		super();
		this.name = name;
		this.active = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
