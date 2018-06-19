package ftnbooking.agent.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addPriceResponse", propOrder = {
    "_return"
})
public class AddPriceResponse {
	@XmlElement(name = "return")
    protected Long _return;

  
    public Long getReturn() {
        return _return;
    }

    
    public void setReturn(Long value) {
        this._return = value;
    }
}
