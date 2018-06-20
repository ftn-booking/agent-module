package ftnbooking.agent.soap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Price")
@Entity
public class Price {
	
	@XmlElement(required = true)
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private Lodging lodging;

	@XmlElement(required = true)
	private long fromDate;

	@XmlElement(required = true)
	private long toDate;
	
	@XmlElement(required = true) 
	private double pricePerDay;
	
	public Price() {
		
	}

	public Price(@NotNull Lodging lodging, long fromDate, long toDate, double pricePerDay) {
		super();
		this.lodging = lodging;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.pricePerDay = pricePerDay;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lodging getLodging() {
		return lodging;
	}

	public void setLodging(Lodging lodging) {
		this.lodging = lodging;
	}

	public long getFromDate() {
		return fromDate;
	}

	public void setFromDate(long fromDate) {
		this.fromDate = fromDate;
	}

	public long getToDate() {
		return toDate;
	}

	public void setToDate(long toDate) {
		this.toDate = toDate;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", lodging=" + lodging + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", pricePerDay=" + pricePerDay + "]";
	}
	
	
}
