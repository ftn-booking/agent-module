package ftnbooking.agent.soap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
@XmlRootElement(name = "ChangePasswordDTO")
public class ChangePasswordDTO {
	@XmlElement(required = true)
	@Size(min = 6)
	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	private String oldPassword;

	@XmlElement(required = true)
	@Size(min = 6)
	@NotEmpty
	@JsonProperty(access = Access.WRITE_ONLY)
	private String newPassword;

	public ChangePasswordDTO() {}

	public ChangePasswordDTO(String oldPassword, String newPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}


}
