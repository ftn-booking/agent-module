package ftnbooking.agent.soap;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "synchronizeFoodServiceTypeResponse", propOrder = {
    "_return"
})
public class SynchronizeFoodServiceTypeResponse {
	@XmlElement(name = "return")
    protected List<FoodServiceType> _return;

  
    public List<FoodServiceType> getReturn() {
        return _return;
    }

    
    public void setReturn(List<FoodServiceType> value) {
        this._return = value;
    }
}
