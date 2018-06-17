package ftnbooking.agent.soap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
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
@XmlRootElement(name = "Reservation")
@Entity
public class Reservation {

	
	@Id
	@GeneratedValue
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@Version
	private Long version;

	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private ApplicationUser user;

	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private Lodging lodging;

	@XmlElement(required = true)
	private long fromDate;

	@XmlElement(required = true)
	private long toDate;

	public Reservation() {}

	public Reservation(ApplicationUser user,
			Lodging lodging,
			long fromDate,
			long toDate) {
		this.user = user;
		this.lodging = lodging;
		this.fromDate = fromDate;
		this.toDate = toDate;
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

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
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

}
