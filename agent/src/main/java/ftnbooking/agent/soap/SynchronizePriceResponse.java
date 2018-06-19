package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizePriceResponse", propOrder = {
    "_return"
})
public class SynchronizePriceResponse {
	@XmlElement(name = "return")
    protected List<Price> _return;

  
    public List<Price> getReturn() {
        return _return;
    }

    
    public void setReturn(List<Price> value) {
        this._return = value;
    }
}
