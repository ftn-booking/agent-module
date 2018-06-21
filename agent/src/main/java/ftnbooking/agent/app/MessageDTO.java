package ftnbooking.agent.app;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

public class MessageDTO {

	@XmlElement(required = true)
	@NotNull
	private Long reservation;
	
	@XmlElement(required = true)
	@NotNull
	private String content;

	public final Long getReservation() {
		return reservation;
	}

	public final void setReservation(Long reservation) {
		this.reservation = reservation;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public MessageDTO() {
	}

	@Override
	public String toString() {
		return "MessageDTO [reservation=" + reservation + ", content=" + content + "]";
	}

}
