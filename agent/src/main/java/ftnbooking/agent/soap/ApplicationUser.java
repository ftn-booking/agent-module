package ftnbooking.agent.soap;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
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
@XmlRootElement(name = "ApplicationUser")
@Entity
public class ApplicationUser {
	@XmlElement(required = true)
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@Version
	private Long version;
	
	@XmlElement(required = true)
	private String email;

	@XmlElement(required = true)
	private String password;

	@XmlElement(required = true)
	private String name;

	@XmlElement(required = true)
	private String lastName;

	@XmlElement(required = true)
	private String city;

	@XmlElement(required = true)
	private String phoneNumber;

	@XmlElement(required = true)
	private ApplicationUserType userType = ApplicationUserType.VISITOR;
	
	@XmlElement()
	private String pid;
	@JsonIgnore
	private int failedLoginAttempts = 0;
	@JsonIgnore
	private String resetToken = UUID.randomUUID().toString();
	
	@XmlElement(required = true)
	private boolean banned = false;
	@XmlElement(required = true)
	private boolean active = true;
	
	public ApplicationUser() {
		
	}

	public ApplicationUser(String email,
			String password,
			String name,
			String lastName,
			String city,
			String phoneNumber) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ApplicationUserType getUserType() {
		return userType;
	}

	public void setUserType(ApplicationUserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "ApplicationUser [id=" + id + ", version=" + version + ", email=" + email + ", password=" + password
				+ ", name=" + name + ", lastName=" + lastName + ", city=" + city + ", phoneNumber=" + phoneNumber
				+ ", userType=" + userType + ", resetToken=" + resetToken + "]";
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

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getFailedLoginAttempts() {
		return failedLoginAttempts;
	}

	public void setFailedLoginAttempts(int failedLoginAttempts) {
		this.failedLoginAttempts = failedLoginAttempts;
	}
	
	
}
