package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizeApplicationUserResponse", propOrder = {
    "_return"
})
public class SynchronizeApplicationUserResponse {
	@XmlElement(name = "return")
    protected List<ApplicationUser> _return;

  
    public List<ApplicationUser> getReturn() {
        return _return;
    }

    
    public void setReturn(List<ApplicationUser> value) {
        this._return = value;
    }
}
