package ftnbooking.agent.app;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import ftnbooking.agent.soap.Lodging;

public class PriceDTO {

	@XmlElement(required = true)
	@NotNull
	private Long lodging;

	@XmlElement(required = true)
	private Date fromDate;

	@XmlElement(required = true)
	private Date toDate;
	
	@XmlElement(required = true) 
	private double pricePerDay;

	public final Long getLodging() {
		return lodging;
	}

	public final void setLodging(Long lodging) {
		this.lodging = lodging;
	}

	public final Date getFromDate() {
		return fromDate;
	}

	public final void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public final Date getToDate() {
		return toDate;
	}

	public final void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public final double getPricePerDay() {
		return pricePerDay;
	}

	public final void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public PriceDTO() {
		
	}
	
}
