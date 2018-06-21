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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "Message")
@Entity
public class Message {

	@XmlElement(required = true)
	@Id
	@GeneratedValue
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private ApplicationUser user;

	@XmlElement(required = true)
	@ManyToOne
	@NotNull
	private Reservation reservation;
	
	@XmlElement(required = true)
	@NotNull
	private String content;
	
	@XmlElement(required = true)
	private boolean userSent;
	public Message() {
		
	}

	public Message(@NotNull ApplicationUser user, @NotNull Reservation reservation, @NotNull String content) {
		super();
		this.user = user;
		this.reservation = reservation;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ApplicationUser getUser() {
		return user;
	}

	public void setUser(ApplicationUser user) {
		this.user = user;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isUserSent() {
		return userSent;
	}

	public void setUserSent(boolean userSent) {
		this.userSent = userSent;
	}
	
	
}
