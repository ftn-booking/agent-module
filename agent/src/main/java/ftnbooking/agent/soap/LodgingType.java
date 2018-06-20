package ftnbooking.agent.soap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**HOTEL, B_AND_B, APARTMENT*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
})
@XmlRootElement(name = "LodgingType")
@Entity
public class LodgingType {
	@XmlElement(required = true)
	@Id
	private Long id;
	
	@XmlElement(required = true)
	private String name;
	
	@XmlElement(required = true)
	private boolean active;
	
	public LodgingType() {
		
	}

	public LodgingType(String name) {
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

	@Override
	public String toString() {
		return "LodgingType [id=" + id + ", name=" + name + ", active=" + active + "]";
	}
	
	

}
