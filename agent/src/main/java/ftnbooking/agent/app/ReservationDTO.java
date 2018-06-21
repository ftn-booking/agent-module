package ftnbooking.agent.app;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import ftnbooking.agent.soap.ApplicationUser;
import ftnbooking.agent.soap.Lodging;

public class ReservationDTO {

	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private String user;

	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private Long lodging;

	@XmlElement(required = true)
	private Date fromDate;

	@XmlElement(required = true)
	private Date toDate;

	@XmlElement(required = true)
	private boolean approved;
	
	@XmlElement(required = true)
	@Max(5)
	@Min(1)
	private Integer rating;
	
	public ReservationDTO() {}

	public final String getUser() {
		return user;
	}

	public final void setUser(String user) {
		this.user = user;
	}

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

	public final boolean isApproved() {
		return approved;
	}

	public final void setApproved(boolean approved) {
		this.approved = approved;
	}

	public final Integer getRating() {
		return rating;
	}

	public final void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
}
