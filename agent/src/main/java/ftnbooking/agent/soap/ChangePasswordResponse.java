package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changePasswordResponse", propOrder = {
    "_return"
})
public class ChangePasswordResponse {
	@XmlElement(name = "return")
    protected boolean _return;

  
    public boolean getReturn() {
        return _return;
    }

    
    public void setReturn(boolean value) {
        this._return = value;
    }
}
